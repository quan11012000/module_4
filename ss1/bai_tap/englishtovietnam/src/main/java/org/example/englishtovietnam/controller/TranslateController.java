package org.example.englishtovietnam.controller;

import org.example.englishtovietnam.repo.IRepository;
import org.example.englishtovietnam.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/translate")
public class TranslateController {
    @Autowired
        private IService translateService;
    @GetMapping
    public String showForm(){
        return "translate/list";
    }
    @PostMapping
    public String transLate(Model model, @RequestParam String word){
        String result = translateService.find(word);
        if (result == null) {
            result = "Not found in dictionary.";
        }
        model.addAttribute("result", word + " → " + result);
        return "translate/list";
    }

}
