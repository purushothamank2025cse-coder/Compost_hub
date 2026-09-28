package com.example.composthub.controller;

import com.example.composthub.model.Payment;
import com.example.composthub.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("payments", service.findAll());
        return "payment/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("payment", service.findById(id));
        return "payment/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("payment") Payment entity) {
        service.save(entity);
        return "redirect:/payment";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/payment";
    }
}
