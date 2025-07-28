package org.example.cart.controller;

import jakarta.servlet.http.HttpSession;
import org.example.cart.entity.CartItem;
import org.example.cart.entity.Order;
import org.example.cart.entity.OrderItem;
import org.example.cart.entity.Product;
import org.example.cart.service.IOrderItemService;
import org.example.cart.service.IOrderService;
import org.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("shops")
public class ShopController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderItemService orderItemService;

    // Lấy danh sách cart từ session
    private List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
    // ========== TRANG CHỦ ==========
    @GetMapping()
    public String showProductList(@RequestParam(name = "keyword", required = false) String keyword, Model model, HttpSession session) {
        List<Product> products = (keyword == null || keyword.isEmpty())
                ? productService.findAll()
                : productService.searchByName(keyword);
        model.addAttribute("products", products);

        List<CartItem> cart = getCart(session);
        model.addAttribute("cartSize", cart.stream().mapToInt(CartItem::getQuantity).sum());
        return "product/list";
    }

    // ========== CHI TIẾT SẢN PHẨM ==========
    @GetMapping("/{id}/detail")
    public String viewProduct(@PathVariable Long id, Model model, HttpSession session) {
        Product product = productService.findById(id).orElse(null);
        if (product == null) return "redirect:/shops";
        model.addAttribute("product", product);

        List<CartItem> cart = getCart(session);
        model.addAttribute("cartSize", cart.stream().mapToInt(CartItem::getQuantity).sum());

        return "product/detail";
    }

    // ========== HIỂN THỊ GIỎ HÀNG ==========
    @GetMapping("/cart")
    public String showCart(Model model, HttpSession session) {
        List<CartItem> cart = getCart(session);
        double total = cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
        model.addAttribute("cartItems", cart);
        model.addAttribute("cartSize", cart.stream().mapToInt(CartItem::getQuantity).sum());
        model.addAttribute("totalAmount", total);
        return "product/cart";
    }

    // ========== THÊM SẢN PHẨM VÀO GIỎ ==========
    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam(defaultValue = "1") int quantity,

                            HttpSession session, RedirectAttributes ra) {
        Product product = productService.findById(productId).orElse(null);
        if (product == null) {
            ra.addFlashAttribute("error", "Sản phẩm không tồn tại");
            return "redirect:cart";
        }

        List<CartItem> cart = getCart(session);
        boolean found = false;
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        if (!found) {
            cart.add(new CartItem(product, quantity));
        }
        session.setAttribute("cart", cart);
        ra.addFlashAttribute("message", "Đã thêm vào giỏ hàng");
        return "redirect:cart";
    }

    // ========== XOÁ SẢN PHẨM TRONG GIỎ ==========
    @PostMapping("/{id}/remove")
    public String removeFromCart(@PathVariable Long id, HttpSession session, RedirectAttributes ra) {
        List<CartItem> cart = getCart(session);
        cart.removeIf(item -> item.getProduct().getId().equals(id));
        session.setAttribute("cart", cart);
        ra.addFlashAttribute("message", "Đã xoá sản phẩm khỏi giỏ");
        return "redirect:/shops/cart";
    }

    // ========== CẬP NHẬT GIỎ HÀNG ==========
    @PostMapping("/{id}/update")
    public String updateQuantity(@PathVariable Long id, @RequestParam int quantity,
                                 HttpSession session, RedirectAttributes ra) {
        if (quantity <= 0) quantity = 1;
        List<CartItem> cart = getCart(session);
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(id)) {
                item.setQuantity(quantity);
                break;
            }
        }
        session.setAttribute("cart", cart);
        ra.addFlashAttribute("message", "Cập nhật số lượng thành công");

        return "redirect:/shops/cart";
    }

    // ========== ĐẶT HÀNG ==========
    @PostMapping("/cart/checkout")
    public String checkout(@RequestParam String name,
                           @RequestParam String email,
                           HttpSession session) {
        List<CartItem> cart = getCart(session);
        if (cart.isEmpty()) return "redirect:/product/cart";

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerName(name);
        order.setCustomerEmail(email);

        orderService.placeOrder(order, cart);

        session.removeAttribute("cart");
        return "redirect:/shops";
    }
}