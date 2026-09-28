package com.example.composthub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.composthub.repository.BudgetRepository;
import com.example.composthub.repository.ProductRepository;
import com.example.composthub.repository.PurchaseOrderRepository;
import com.example.composthub.repository.SalesOrderRepository;
import com.example.composthub.repository.WasteIntakeRepository;
import com.example.composthub.service.ReportService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reports")
public class ReportController {
    private final BudgetRepository budgetRepository;
    private final ProductRepository productRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SalesOrderRepository salesOrderRepository;
    private final WasteIntakeRepository wasteIntakeRepository;
    private final ReportService reportService;

    public ReportController(BudgetRepository budgetRepository,
                            ProductRepository productRepository,
                            PurchaseOrderRepository purchaseOrderRepository,
                            SalesOrderRepository salesOrderRepository,
                            WasteIntakeRepository wasteIntakeRepository,
                            ReportService reportService) {
        this.budgetRepository = budgetRepository;
        this.productRepository = productRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.salesOrderRepository = salesOrderRepository;
        this.wasteIntakeRepository = wasteIntakeRepository;
        this.reportService = reportService;
    }

    @GetMapping
    public String reports(Model model) {
        model.addAttribute("budgetCount", budgetRepository.count());
        model.addAttribute("productCount", productRepository.count());
        model.addAttribute("purchaseCount", purchaseOrderRepository.count());
        model.addAttribute("salesCount", salesOrderRepository.count());
        model.addAttribute("wasteCount", wasteIntakeRepository.count());
        model.addAllAttributes(reportService.summary());
        return "reports/budget-report";
    }

    @GetMapping("/balance-sheet")
    public String balanceSheet(Model model) {
        model.addAttribute("productCount", productRepository.count());
        model.addAttribute("purchaseCount", purchaseOrderRepository.count());
        model.addAttribute("salesCount", salesOrderRepository.count());
        model.addAllAttributes(reportService.summary());
        return "reports/balance-sheet";
    }

    @GetMapping("/profit-loss")
    public String profitLoss(Model model) {
        model.addAttribute("salesCount", salesOrderRepository.count());
        model.addAttribute("purchaseCount", purchaseOrderRepository.count());
        model.addAllAttributes(reportService.summary());
        return "reports/profit-loss";
    }

    @GetMapping("/api/summary")
    @ResponseBody
    public java.util.Map<String, Object> summary() {
        return reportService.summary();
    }
}
