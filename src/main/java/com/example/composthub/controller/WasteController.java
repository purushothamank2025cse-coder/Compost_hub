package com.example.composthub.controller;

import com.example.composthub.model.WasteIntake;
import com.example.composthub.service.WasteIntakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/waste")
public class WasteController {
    private final WasteIntakeService service;

    public WasteController(WasteIntakeService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("wasteIntakes", service.findAll());
        return "waste/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("wasteIntake", new WasteIntake());
        return "waste/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("wasteIntake", service.findById(id));
        return "waste/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("wasteIntake") WasteIntake entity) {
        service.save(entity);
        return "redirect:/waste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/waste";
    }
}
