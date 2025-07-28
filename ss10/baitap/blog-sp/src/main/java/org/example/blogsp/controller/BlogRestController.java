package org.example.blogsp.controller;
import org.example.blogsp.dto.BlogDto;
import org.example.blogsp.entity.Blog;
import org.example.blogsp.entity.Category;
import org.example.blogsp.service.BlogService;
import org.example.blogsp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogRestController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;
    private BlogDto convertToDto(Blog blog) {
        BlogDto dto = modelMapper.map(blog, BlogDto.class);
        return dto;
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> findAllBlog(@RequestParam(name="page", defaultValue = "0")int page) {
        int size=6;
        List<Blog> list = blogService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping ("/category")
    ResponseEntity<List<Category>> findAllCategory() {
        int size=20;
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("category/{idType}")
    public ResponseEntity<List<BlogDto>> findByCategory(@PathVariable("idType") Integer idType) {
        List<Blog> blogs = blogService.findByCategory_IdType(idType);
        List<BlogDto> dtos = blogs.stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlogDetail(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(blog));
    }
}