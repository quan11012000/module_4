package org.example.restaurant_pos.controller;

import org.example.restaurant_pos.entity.Invoice;
import org.example.restaurant_pos.entity.Order;

import org.example.restaurant_pos.entity.Payment;

import org.example.restaurant_pos.enums.OrderStatus;
import org.example.restaurant_pos.enums.PaymentMethod;
import org.example.restaurant_pos.repository.IPaymentRepository;
import org.example.restaurant_pos.service.IInvoiceService;
import org.example.restaurant_pos.service.IOrderService;
import org.example.restaurant_pos.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


    @Controller
    @RequestMapping("/orders")
    public class OderController {

        @Autowired
        private IOrderService orderService;
        @Autowired
        private IPaymentService paymentService;
        @Autowired
        private IInvoiceService invoiceService;

        @GetMapping("/ready")
        public String listReadyOrders(Model model) {
            List<Order> readyOrders = orderService.findByStatus(OrderStatus.READY);
            model.addAttribute("orders", readyOrders);
            return "orders";
        }

        @GetMapping("/checkout/{orderId}")
        public String checkoutForm(@PathVariable Integer orderId, Model model) {
            Order order = orderService.findById(orderId);
            model.addAttribute("order", order);
            model.addAttribute("paymentMethods", PaymentMethod.values());
            return "checkout";
        }

        @PostMapping("/checkout")
        public String processCheckout(@ModelAttribute Payment payment) {
            payment.setPaymentTime(LocalDateTime.now());
            // Nếu chọn SANDBOX, redirect đến sandbox giả lập hoặc xử lý tùy chỉnh
            if (payment.getMethod() == PaymentMethod.SANDBOX) {
                // fake xử lý sandbox thành công
            }
            Integer invoiceId = payment.getInvoice().getId();
            if (payment.getMethod() == PaymentMethod.SANDBOX) {
                return "redirect:/sandbox/confirm?invoiceId=" + invoiceId;
            }

            // Nếu không phải SANDBOX thì xử lý bình thường
            paymentService.save(payment);
            return "redirect:/orders/invoice/" + invoiceId;
        }

        @GetMapping("/invoice/{invoiceId}")
        public String viewInvoice(@PathVariable Integer invoiceId, Model model) {
            Invoice invoice = invoiceService.findById(invoiceId);
            model.addAttribute("invoice", invoice);
            return "invoice";
        }
    }


