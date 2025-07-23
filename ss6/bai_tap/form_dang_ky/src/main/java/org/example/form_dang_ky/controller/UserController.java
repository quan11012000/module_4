package org.example.form_dang_ky.controller;

import org.example.form_dang_ky.entity.User;
import org.example.form_dang_ky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
@Autowired
private UserService userService;
@GetMapping
    public String displayAllUsers(Model model, @RequestParam(name="page",defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "desc")String sort,
                                  @RequestParam(required = false)String keyword) {
int size=10;
    Sort sortname = sort.equals("desc")?Sort.by("createdAt").descending():Sort.by("createdAt").ascending();
    Pageable pageable = PageRequest.of(page, size, sortname);
    if (keyword == null) {
        keyword = "";
    }
    model.addAttribute("users", userService.searchByName(keyword,pageable));
    model.addAttribute("sort", sort);
    model.addAttribute("keyword", keyword);
    return "list";
}
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        userService.add(user);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("user", userService.findById(id));
        if(userService.findById(id)==null){
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy user");
            return "redirect:/users";
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute User user,RedirectAttributes redirectAttributes) {
        if(userService.findById(user.getId())==null){
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy user");
            return "redirect:/users";
        }
        userService.update(user.getId(), user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        boolean removed= userService.deleteById(id);
        if(removed){
            redirectAttributes.addFlashAttribute("message", "Xoá thành công");
        }else{
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy user");

        }
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("user", userService.findById(id));
        if (userService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy user");
            return "redirect:/users";
        }
        return "detail";
    }
}
