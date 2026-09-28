package com.example.composthub.controller;

import com.example.composthub.model.Inventory;
import com.example.composthub.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("inventorys", service.findAll());
        return "inventory/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        return "inventory/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("inventory", service.findById(id));
        return "inventory/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("inventory") Inventory entity) {
        service.save(entity);
        return "redirect:/inventory";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/inventory";
    }
}
