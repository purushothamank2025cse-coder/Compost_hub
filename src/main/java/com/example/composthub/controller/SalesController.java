package com.example.composthub.controller;

import com.example.composthub.model.SalesOrder;
import com.example.composthub.service.SalesOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sales")
public class SalesController {
    private final SalesOrderService service;

    public SalesController(SalesOrderService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("salesOrders", service.findAll());
        return "sales/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("salesOrder", new SalesOrder());
        return "sales/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("salesOrder", service.findById(id));
        return "sales/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("salesOrder") SalesOrder entity) {
        service.save(entity);
        return "redirect:/sales";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/sales";
    }
}
