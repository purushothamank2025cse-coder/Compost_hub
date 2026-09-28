package com.example.composthub.controller;

import com.example.composthub.model.Budget;
import com.example.composthub.service.BudgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetService service;

    public BudgetController(BudgetService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("budgets", service.findAll());
        return "budget/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("budget", new Budget());
        return "budget/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("budget", service.findById(id));
        return "budget/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("budget") Budget entity) {
        service.save(entity);
        return "redirect:/budget";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/budget";
    }
}
