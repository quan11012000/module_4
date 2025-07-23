package org.example.dang_ky.controller;

import jakarta.validation.Valid;
import org.example.dang_ky.dto.UserCreateDTO;
import org.example.dang_ky.entity.User;
import org.example.dang_ky.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    // Trang hiển thị form đăng ký
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserCreateDTO());
        return "register";
    }


    @PostMapping("/register")
    public String processRegister(@ModelAttribute("userDto") @Valid UserCreateDTO dto,
                                  BindingResult result,
                                  RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "register";
        }
        User user = modelMapper.map(dto, User.class);
        userService.save(user);
        redirect.addFlashAttribute("message", "Đăng ký thành công!");
        redirect.addFlashAttribute("user", user);
        return "redirect:/users/success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "result";
    }
}
