package org.example.springgreeting.controller;

import org.example.springgreeting.entity.Customer;
import org.example.springgreeting.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping
    // "customers" là item bên view , return đường dẫn thư mục+ file view
    public String displayAll(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }
    @GetMapping("/create")
    public String viewCreate(Model model) {
        return "customer/create";
    }
    @PostMapping("/create")
    public String processCreate(@ModelAttribute("customer") Customer customer) {
        customerService.add(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message","New customer has been added");
        return "redirect:/customer";
    }
}
