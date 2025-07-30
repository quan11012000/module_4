package org.example.blogsp.controller;

import org.example.blogsp.entity.Blog;
import org.example.blogsp.service.BlogService;
import org.example.blogsp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    // ✅ Trang danh sách blog
    @GetMapping
    public String displayAll(Model model,
                             @RequestParam(name = "page", defaultValue = "0") int page,
                             @RequestParam(defaultValue = "desc") String sort,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(required = false) Integer categoryId) {

        int size = 6;
        Sort sortOption = sort.equals("desc") ? Sort.by("createdAt").descending() : Sort.by("createdAt").ascending();
        Pageable pageable = PageRequest.of(page, size, sortOption);

        if (keyword == null) keyword = "";
        if (categoryId == null) categoryId = 0;

        model.addAttribute("blogs", blogService.filter(keyword, categoryId, pageable));
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("sort", sort);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);
        return "list";
    }
    @GetMapping("/search")
    @ResponseBody
    public Page<Blog> search(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "desc") String sort,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(required = false) Integer categoryId) {

        int size = 6;
        Sort sortOption = sort.equals("desc") ? Sort.by("createdAt").descending() : Sort.by("createdAt").ascending();
        Pageable pageable = PageRequest.of(page, size, sortOption);

        if (keyword == null) keyword = "";
        if (categoryId == null) categoryId = 0;

        return blogService.filter(keyword, categoryId, pageable);
    }
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
    public String editForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryService.findAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.findById(blog.getId()) == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/blogs";
        }
        blogService.update(blog.getId(), blog);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/blogs";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        boolean removed = blogService.deleteById(id);
        if (removed) {
            redirectAttributes.addFlashAttribute("message", "Xoá thành công");
        } else {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
        }
        return "redirect:/blogs";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog);
        return "detail";
    }
//    @GetMapping("/load")
//    public String loadMoreBlogs(@RequestParam(defaultValue = "0") int page,
//                                @RequestParam(defaultValue = "desc") String sort,
//                                @RequestParam(required = false) String keyword,
//                                @RequestParam(required = false) Integer categoryId,
//                                Model model) {
//        Pageable pageable = PageRequest.of(page, 6,
//                sort.equals("desc") ? Sort.by("createdAt").descending() : Sort.by("createdAt").ascending());
//        Page<Blog> blogs = blogService.filter(keyword == null ? "" : keyword,
//                categoryId == null ? 0 : categoryId, pageable);
//        model.addAttribute("blogs", blogs.getContent());
//        return "fragments/post-container :: postContainer";
//    }
}
