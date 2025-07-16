package org.example.sandwichcondiments.controller;

import org.example.sandwichcondiments.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SanwichController {
    @Autowired
    private ISandwichService sandwichService;

    @GetMapping("/")
    public String showForm(Model model) {
        List<String> condiments = sandwichService.getAvailableCondiments();
        model.addAttribute("condiments", condiments);
        return "index";

    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiments, Model model) {
        if (condiments == null || condiments.length == 0) {
            model.addAttribute("error", "Bạn phải chọn ít nhất một gia vị!");
            model.addAttribute("condiments", sandwichService.getAvailableCondiments()); // nạp lại form
            return "index";
        }
        List<String> selected = Arrays.asList(condiments);
        model.addAttribute("selectedCondiments", selected);
        return "sandwich";
    }

}
