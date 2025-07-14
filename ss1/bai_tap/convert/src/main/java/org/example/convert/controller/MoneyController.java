package org.example.convert.controller;

import org.example.convert.service.impl.MoneyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/money")
public class MoneyController {
    @Autowired
    private MoneyServiceImpl moneyServiceImpl;
    @GetMapping
    public String showForm(){
        return "money/list";
    }
    @PostMapping
    public String convert(@RequestParam String amount,
                          @RequestParam String from,
                          @RequestParam String to,
                          Model model) {
        String result = moneyServiceImpl.getResultString(amount, from, to);
        boolean isError = result.contains("Vui lòng nhập một số hợp lệ!");
        model.addAttribute("result", result);
        model.addAttribute("isError", isError);
        return "money/list";
    }
}
