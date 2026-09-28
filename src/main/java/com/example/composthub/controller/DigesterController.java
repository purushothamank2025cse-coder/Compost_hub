package com.example.composthub.controller;

import com.example.composthub.model.Digester;
import com.example.composthub.service.DigesterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/digester")
public class DigesterController {
    private final DigesterService service;

    public DigesterController(DigesterService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("digesters", service.findAll());
        return "digester/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("digester", new Digester());
        return "digester/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("digester", service.findById(id));
        return "digester/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("digester") Digester entity) {
        service.save(entity);
        return "redirect:/digester";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/digester";
    }
}
