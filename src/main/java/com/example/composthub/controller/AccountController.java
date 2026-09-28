package com.example.composthub.controller;
import com.example.composthub.model.Account;
import com.example.composthub.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/account")
public class AccountController {
    private final AccountService service;
    public AccountController(AccountService service){this.service=service;}
    @GetMapping public String list(Model model){model.addAttribute("accounts",service.findAll());return "account/list";}
    @GetMapping("/new") public String create(Model model){model.addAttribute("account",new Account());return "account/form";}
    @GetMapping("/edit/{id}") public String edit(@PathVariable Long id,Model model){model.addAttribute("account",service.findById(id));return "account/form";}
    @PostMapping("/save") public String save(@ModelAttribute("account") Account a){service.save(a);return "redirect:/account";}
    @GetMapping("/delete/{id}") public String delete(@PathVariable Long id){service.deleteById(id);return "redirect:/account";}
}
