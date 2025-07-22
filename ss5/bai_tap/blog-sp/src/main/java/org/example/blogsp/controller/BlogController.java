package org.example.blogsp.controller;

import org.example.blogsp.entity.Blog;
import org.example.blogsp.service.BlogService;
import org.example.blogsp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String displayAll(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        int size = 6;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        model.addAttribute("blogs", blogService.findAll(pageRequest));
        model.addAttribute("categoryList", categoryService.findAll());
        return "list";
    }
//    @GetMapping
//    public String list(Model model) {
//        model.addAttribute("blogs", blogService.findAll());
//        return "list";
//    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("blog", blogService.findById(id));
        if(blogService.findById(id)==null){
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/blogs";
        }
        model.addAttribute("categoryList", categoryService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes) {
        if(blogService.findById(blog.getId())==null){
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/blogs";
        }
        blogService.update(blog.getId(), blog);
        return "redirect:/blogs";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        boolean removed= blogService.deleteById(id);
        if(removed){
            redirectAttributes.addFlashAttribute("message", "Xoá thành công");
        }else{
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");

        }
        return "redirect:/blogs";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("blog", blogService.findById(id));
        if(blogService.findById(id)==null){
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/blogs";
        }
        return "detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword,
                         @RequestParam(required = false) Integer categoryId,
                         @RequestParam(defaultValue = "0") int page,
                         Model model,RedirectAttributes redirectAttributes) {

        int size = 6;
        PageRequest pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Blog> blogs;
        if (categoryId != null && categoryId != 0) {
            blogs = blogService.findByTitleContainingAndCategory_IdType(keyword, categoryId, pageable);
        } else {
            blogs = blogService.searchByName(keyword, pageable);
        }

        if (blogs.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy blog");
            return "redirect:/blogs";
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("keyword", keyword);
        model.addAttribute("selectedCategoryId", categoryId);
        model.addAttribute("categoryList", categoryService.findAll());
        return "list";
    }
    @GetMapping("/category/{idType}")
    public String filterByCategory(@PathVariable("idType") Integer idType,
                                   @RequestParam(name="page", defaultValue = "0") int page,
                                   Model model) {
        int size = 6;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Blog> blogs = blogService.findByCategory_IdType(idType, pageRequest);

        model.addAttribute("blogs", blogs);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("selectedCategoryId", idType); // Dùng để active button
        return "list";
    }

}
