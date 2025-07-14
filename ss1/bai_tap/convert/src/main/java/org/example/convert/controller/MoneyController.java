package org.example.convert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/money")
public class MoneyController {
    @GetMapping
    public String showForm(){
        return "money/list";
    }
    @PostMapping
    public String convert(@RequestParam double amount,
                          @RequestParam String from,
                          @RequestParam String to,
                          Model model){
        double rate = 1.0;
        if(from.equals("USD") && to.equals("VND")){
            rate = 25000;
        }else if(from.equals("VND") && to.equals("USD")){
            rate = 1.0/25000;
        }
        double resultAmount = amount * rate;
        String result = String.format("%.0f %s = %.0f %s", amount, from, resultAmount, to);
        model.addAttribute("result", result);
        return "money/list";
    }
}
