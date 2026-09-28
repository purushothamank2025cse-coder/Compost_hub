package com.example.composthub.controller;

import com.example.composthub.model.PurchaseOrder;
import com.example.composthub.service.PurchaseOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseOrderService service;

    public PurchaseController(PurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("purchaseOrders", service.findAll());
        return "purchase/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("purchaseOrder", new PurchaseOrder());
        return "purchase/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("purchaseOrder", service.findById(id));
        return "purchase/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("purchaseOrder") PurchaseOrder entity) {
        service.save(entity);
        return "redirect:/purchase";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/purchase";
    }
}
