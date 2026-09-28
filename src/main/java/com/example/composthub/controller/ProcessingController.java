package com.example.composthub.controller;

import com.example.composthub.model.ProcessingBatch;
import com.example.composthub.service.ProcessingBatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/processing")
public class ProcessingController {
    private final ProcessingBatchService service;

    public ProcessingController(ProcessingBatchService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("processingBatchs", service.findAll());
        return "processing/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("processingBatch", new ProcessingBatch());
        return "processing/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("processingBatch", service.findById(id));
        return "processing/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("processingBatch") ProcessingBatch entity) {
        service.save(entity);
        return "redirect:/processing";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/processing";
    }

    @PostMapping("/complete/{id}")
    public String complete(@PathVariable Long id) {
        service.complete(id);
        return "redirect:/processing";
    }
}
