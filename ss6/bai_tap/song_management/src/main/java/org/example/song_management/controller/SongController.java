package org.example.song_management.controller;

import jakarta.validation.Valid;
import org.example.song_management.dto.SongDTO;
import org.example.song_management.entity.Song;
import org.example.song_management.service.ISongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("songDTO") @Valid SongDTO dto,
                       BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "form";
        }
        Song song = modelMapper.map(dto, Song.class);
        song.setId(null);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/songs";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute("songDTO") @Valid SongDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (songService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy bài nhạc");
            return "redirect:/songs";
        }
        if (result.hasErrors()) {
            return "form";
        }
        Song song = modelMapper.map(dto, Song.class);
        song.setId(id);
        songService.save(song);
        return "redirect:/songs";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("songDTO", songService.findById(id));
        if (songService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy bài hát");
            return "redirect:/songs";
        }
        return "form";
    }

}