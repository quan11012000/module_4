package org.example.updatemail.controller;

import org.example.updatemail.entity.Email;
import org.example.updatemail.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;
    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("email", emailService.getSettings());
        model.addAttribute("languages",emailService.getLanguages());
        model.addAttribute("pageSizes",emailService.getPageSizes());
        return "mail/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("email") Email email,
                         RedirectAttributes redirect) {
        emailService.update(email);
        redirect.addFlashAttribute("email", email);
        redirect.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/email/detail";
    }

    @GetMapping("/detail")
    public String showDetail() {
        return "mail/detail";
    }
}
