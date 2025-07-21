package org.example.blogsp.controller;

import org.example.blogsp.entity.Blog;
import org.example.blogsp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping
    public String list(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("massage", "them moi thanh cong");
        return "redirect:/blogs";
    }



    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("blog", blogService.findById(id));
        if(blogService.findById(id)==null){
            redirectAttributes.addFlashAttribute("error", "khong tim thay");
            return "redirect:/blogs";
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes) {
        if(blogService.findById(blog.getId())==null){
            redirectAttributes.addFlashAttribute("error", "khong tim thay");
            return "redirect:/blogs";
        }
        blogService.update(blog.getId(), blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        boolean removed= blogService.deleteById(id);
        if(removed){
            redirectAttributes.addFlashAttribute("massage", "Xoa thanh cong");
        }else{
            redirectAttributes.addFlashAttribute("error", "Khong tim thay blog");
        }
        return "redirect:/blogs";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("blog", blogService.findById(id));
        if(blogService.findById(id)==null){
            redirectAttributes.addFlashAttribute("error", "khong tim thay");
            return "redirect:/blogs";
        }
        return "detail";
    }
}
