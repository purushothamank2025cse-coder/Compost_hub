package com.example.composthub.service;

import com.example.composthub.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ReportService {
    private final ProductRepository products;
    private final InventoryRepository inventory;
    private final PurchaseOrderRepository purchases;
    private final SalesOrderRepository sales;
    private final WasteIntakeRepository waste;
    private final BudgetRepository budgets;

    public ReportService(ProductRepository products, InventoryRepository inventory,
                         PurchaseOrderRepository purchases, SalesOrderRepository sales,
                         WasteIntakeRepository waste, BudgetRepository budgets) {
        this.products = products;
        this.inventory = inventory;
        this.purchases = purchases;
        this.sales = sales;
        this.waste = waste;
        this.budgets = budgets;
    }

    public Map<String, Object> summary() {
        return Map.of(
                "productCount", products.count(),
                "inventoryQuantity", sum(inventory.findAll().stream().map(i -> i.getQuantity())),
                "wasteQuantity", sum(waste.findAll().stream().map(i -> i.getQuantity())),
                "salesRevenue", sum(sales.findAll().stream().map(s -> s.getAmount())),
                "purchaseCost", sum(purchases.findAll().stream().map(p -> p.getAmount())),
                "budgetPlanned", sum(budgets.findAll().stream().map(b -> b.getPlannedAmount())),
                "budgetActual", sum(budgets.findAll().stream().map(b -> b.getActualAmount()))
        );
    }

    private BigDecimal sum(java.util.stream.Stream<BigDecimal> values) {
        return values.filter(java.util.Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
