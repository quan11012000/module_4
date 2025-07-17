package org.example.productmanagementthymeleaf.controller;

import org.example.productmanagementthymeleaf.entity.Product;
import org.example.productmanagementthymeleaf.service.IProductService;
import org.example.productmanagementthymeleaf.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String list(Model model) {
        List<Product> products = productService.finAll();
        model.addAttribute("products", products);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        //product.setId((int)(Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product has been saved successfully");
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message", "Product has been updated successfully");
        return "redirect:/products";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Product has been deleted successfully");
        return "redirect:/products";
    }
    @GetMapping("/{id}/detail")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        if (keyword == null || keyword.isEmpty()) {
            return "redirect:/products";
        }
        List<Product> products = productService.searchByName(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "list";
    }
}
