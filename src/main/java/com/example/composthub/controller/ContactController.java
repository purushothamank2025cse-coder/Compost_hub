package com.example.composthub.controller;

import com.example.composthub.model.Contact;
import com.example.composthub.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private final ContactService service;
    public ContactController(ContactService service){ this.service=service; }
    @GetMapping public String list(Model model){ model.addAttribute("contacts",service.findAll()); return "contact/list"; }
    @GetMapping("/new") public String create(Model model){ model.addAttribute("contact",new Contact()); return "contact/form"; }
    @GetMapping("/edit/{id}") public String edit(@PathVariable Long id,Model model){ model.addAttribute("contact",service.findById(id)); return "contact/form"; }
    @PostMapping("/save") public String save(@ModelAttribute("contact") Contact c){service.save(c);return "redirect:/contact";}
    @GetMapping("/delete/{id}") public String delete(@PathVariable Long id){service.deleteById(id);return "redirect:/contact";}
}
