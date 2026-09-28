package com.example.composthub.controller;

import com.example.composthub.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;
    private final WasteIntakeRepository wasteIntakeRepository;
    private final SalesOrderRepository salesOrderRepository;

    public HomeController(ProductRepository productRepository,
                           InventoryRepository inventoryRepository,
                           WasteIntakeRepository wasteIntakeRepository,
                           SalesOrderRepository salesOrderRepository) {
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
        this.wasteIntakeRepository = wasteIntakeRepository;
        this.salesOrderRepository = salesOrderRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("productCount", productRepository.count());
        model.addAttribute("inventoryCount", inventoryRepository.count());
        model.addAttribute("wasteCount", wasteIntakeRepository.count());
        model.addAttribute("salesCount", salesOrderRepository.count());
        return "index";
    }
}


