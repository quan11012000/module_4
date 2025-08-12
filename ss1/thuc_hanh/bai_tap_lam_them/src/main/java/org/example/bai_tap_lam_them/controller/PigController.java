package org.example.bai_tap_lam_them.controller;

import jakarta.validation.Valid;
import org.example.bai_tap_lam_them.dto.PigDTO;
import org.example.bai_tap_lam_them.entity.Country;
import org.example.bai_tap_lam_them.entity.Pig;
import org.example.bai_tap_lam_them.service.ICountryService;
import org.example.bai_tap_lam_them.service.IPigService;
import org.example.bai_tap_lam_them.service.impl.CountryService;
import org.example.bai_tap_lam_them.service.impl.PigService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pigs")
public class PigController {
    @Autowired
    private IPigService pigService;
    @Autowired
    private ICountryService countryService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "desc") String sort, @RequestParam(required = false) String keyword, @RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sortOption = sort.equals("desc")?Sort.by("createdAt").descending():Sort.by("createdAt").ascending();
        int size = 6;
        Pageable pageable = PageRequest.of(page, size);
        if (keyword == null) {
            keyword = "";
        }
        Page<Pig> pigs = pigService.findByName(keyword, pageable);
        model.addAttribute("pigs", pigs);
        model.addAttribute("keyword", keyword);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pig", new PigDTO());
        model.addAttribute("countryList", countryService.showAllCountry());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("pig") PigDTO pigDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("countryList", countryService.showAllCountry());
            return "create";
        }
        Pig pig= modelMapper.map(pigDto, Pig.class);
        pigService.add(pig);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/pigs";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        boolean removed = pigService.deleteById(id);
        if (removed) {
            redirectAttributes.addFlashAttribute("message", "Xoá thành công");
        } else {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy con heo");
        }
        return "redirect:/pigs";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("pig", pigService.findById(id));
        if (pigService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy con hep");
            return "redirect:/pigs";
        }
        return "detail";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("pig", pigService.findById(id));
        if (pigService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/pigs";
        }
        model.addAttribute("countryList", countryService.showAllCountry());
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute Pig pig, BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("countryList", countryService.showAllCountry());
            return "update";
        }
        if (pigService.findById(pig.getId()) == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy Blog");
            return "redirect:/pigs";
        }
        pigService.update(pig.getId(), pig);
        redirectAttributes.addFlashAttribute("message","Cập nhật thành công");
        return "redirect:/pigs";
    }
}
