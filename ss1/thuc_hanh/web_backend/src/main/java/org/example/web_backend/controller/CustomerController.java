package org.example.web_backend.controller;

import org.example.web_backend.entity.Customer;
import org.example.web_backend.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public String displayAll(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/list";
    }
    @GetMapping("/{id}")
    public String showCustomerDetail(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "error/404"; // Trang lỗi nếu không tìm thấy
        }
        model.addAttribute("customer", customer);
        return "customers/detail";
    }
}