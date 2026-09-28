package com.example.composthub.config;

import com.example.composthub.model.*;
import com.example.composthub.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.IntFunction;

@Component
public class DemoDataInitializer implements ApplicationRunner {
    private static final int MINIMUM_RECORDS = 10;

    private final AccountRepository accounts;
    private final BudgetRepository budgets;
    private final BudgetLineRepository budgetLines;
    private final ContactRepository contacts;
    private final CustomerInvoiceRepository customerInvoices;
    private final DigesterRepository digesters;
    private final InventoryRepository inventory;
    private final JournalEntryRepository journalEntries;
    private final PaymentRepository payments;
    private final ProcessingBatchRepository processingBatches;
    private final ProductRepository products;
    private final PurchaseOrderRepository purchaseOrders;
    private final PurchaseOrderItemRepository purchaseOrderItems;
    private final SalesOrderRepository salesOrders;
    private final SalesOrderItemRepository salesOrderItems;
    private final VendorBillRepository vendorBills;
    private final WasteIntakeRepository wasteIntakes;

    public DemoDataInitializer(AccountRepository accounts, BudgetRepository budgets,
                               BudgetLineRepository budgetLines, ContactRepository contacts,
                               CustomerInvoiceRepository customerInvoices, DigesterRepository digesters,
                               InventoryRepository inventory, JournalEntryRepository journalEntries,
                               PaymentRepository payments, ProcessingBatchRepository processingBatches,
                               ProductRepository products, PurchaseOrderRepository purchaseOrders,
                               PurchaseOrderItemRepository purchaseOrderItems, SalesOrderRepository salesOrders,
                               SalesOrderItemRepository salesOrderItems, VendorBillRepository vendorBills,
                               WasteIntakeRepository wasteIntakes) {
        this.accounts = accounts;
        this.budgets = budgets;
        this.budgetLines = budgetLines;
        this.contacts = contacts;
        this.customerInvoices = customerInvoices;
        this.digesters = digesters;
        this.inventory = inventory;
        this.journalEntries = journalEntries;
        this.payments = payments;
        this.processingBatches = processingBatches;
        this.products = products;
        this.purchaseOrders = purchaseOrders;
        this.purchaseOrderItems = purchaseOrderItems;
        this.salesOrders = salesOrders;
        this.salesOrderItems = salesOrderItems;
        this.vendorBills = vendorBills;
        this.wasteIntakes = wasteIntakes;
    }

    @Override
    public void run(org.springframework.boot.ApplicationArguments args) {
        seedAccounts();
        seedBudgets();
        seedBudgetLines();
        seedContacts();
        seedDigesters();
        seedInventory();
        seedProducts();
        seedWasteIntakes();
        seedPurchaseOrders();
        seedPurchaseOrderItems();
        seedSalesOrders();
        seedSalesOrderItems();
        seedCustomerInvoices();
        seedVendorBills();
        seedProcessingBatches();
        seedPayments();
        seedJournalEntries();
    }

    private void seedAccounts() {
        ensureMinimum(accounts, i -> {
            Account account = base(new Account(), i, "Demo account " + twoDigits(i),
                    "Sample compost hub ledger account", null, (long) (10000 + i * 250), "Active");
            account.setAccountType(switch (i % 4) {
                case 0 -> "Asset";
                case 1 -> "Revenue";
                case 2 -> "Expense";
                default -> "Liability";
            });
            account.setBalance(decimal(10000 + i * 250));
            return account;
        });
    }

    private void seedBudgets() {
        ensureMinimum(budgets, i -> {
            Budget budget = base(new Budget(), i, "Demo monthly budget " + twoDigits(i),
                    "Operating budget for composting activities", null, (long) (5000 + i * 350), "Active");
            budget.setPeriod(LocalDate.now().minusMonths(i - 1L).toString().substring(0, 7));
            budget.setPlannedAmount(decimal(5000 + i * 350));
            budget.setActualAmount(decimal(4200 + i * 275));
            return budget;
        });
    }

    private void seedBudgetLines() {
        ensureMinimum(budgetLines, i -> base(new BudgetLine(), i, "Demo budget line " + twoDigits(i),
                "Sample budget allocation", null, (long) (300 + i * 25), "Planned"));
    }

    private void seedContacts() {
        ensureMinimum(contacts, i -> {
            Contact contact = base(new Contact(), i, "Demo contact " + twoDigits(i),
                    "Local compost hub partner", null, null, "Active");
            contact.setContactType(i % 2 == 0 ? "Vendor" : "Customer");
            contact.setEmail("partner" + twoDigits(i) + "@example.com");
            contact.setPhone("+1-202-555-" + String.format("%04d", 1000 + i));
            contact.setAddress((100 + i) + " Garden Street");
            return contact;
        });
    }

    private void seedDigesters() {
        ensureMinimum(digesters, i -> {
            Digester digester = base(new Digester(), i, "Demo digester " + twoDigits(i),
                    "Anaerobic digestion vessel", null, null, "Operational");
            digester.setTargetTemperature(decimal(37));
            digester.setCurrentTemperature(decimal(35 + i % 5));
            digester.setSensorId("SENSOR-" + twoDigits(i));
            return digester;
        });
    }

    private void seedInventory() {
        ensureMinimum(inventory, i -> {
            Inventory item = base(new Inventory(), i, "Demo inventory " + twoDigits(i),
                    "Reusable organic material stock", decimal(100 + i * 12), (long) (250 + i * 20), "In Stock");
            item.setUnit("kg");
            item.setProductType(i % 2 == 0 ? "Organic waste" : "Compost");
            item.setReorderLevel(decimal(20));
            return item;
        });
    }

    private void seedProducts() {
        ensureMinimum(products, i -> {
            Product product = base(new Product(), i, "Demo compost product " + twoDigits(i),
                    "Quality-tested organic soil amendment", decimal(20 + i * 2), (long) (12 + i), "Available");
            product.setSku("COM-" + twoDigits(i));
            product.setUnit("bag");
            product.setUnitPrice(decimal(12 + i));
            return product;
        });
    }

    private void seedWasteIntakes() {
        ensureMinimum(wasteIntakes, i -> {
            WasteIntake intake = base(new WasteIntake(), i, "Demo waste intake " + twoDigits(i),
                    "Community-organized organic waste collection", decimal(80 + i * 10), null, "Received");
            intake.setSource("Community collection point " + twoDigits(i));
            intake.setIntakeDate(date(i));
            intake.setMaterialType(i % 2 == 0 ? "Food scraps" : "Yard trimmings");
            return intake;
        });
    }

    private void seedPurchaseOrders() {
        ensureMinimum(purchaseOrders, i -> {
            PurchaseOrder order = base(new PurchaseOrder(), i, "Demo purchase order " + twoDigits(i),
                    "Supply order for compost hub operations", null, (long) (400 + i * 45), "Open");
            order.setVendor("Green Supply Co. " + twoDigits(i));
            order.setOrderDate(date(i));
            order.setDueDate(date(i - 30));
            return order;
        });
    }

    private void seedPurchaseOrderItems() {
        ensureMinimum(purchaseOrderItems, i -> base(new PurchaseOrderItem(), i,
                "Demo purchase item " + twoDigits(i), "Organic processing supplies",
                decimal(10 + i), (long) (40 + i * 5), "Received"));
    }

    private void seedSalesOrders() {
        ensureMinimum(salesOrders, i -> {
            SalesOrder order = base(new SalesOrder(), i, "Demo sales order " + twoDigits(i),
                    "Finished compost product order", decimal(15 + i), (long) (180 + i * 30), "Confirmed");
            order.setCustomer("Community Garden " + twoDigits(i));
            order.setOrderDate(date(i));
            order.setDueDate(date(i - 14));
            return order;
        });
    }

    private void seedSalesOrderItems() {
        ensureMinimum(salesOrderItems, i -> base(new SalesOrderItem(), i,
                "Demo sales item " + twoDigits(i), "Bagged organic compost",
                decimal(5 + i), (long) (60 + i * 8), "Fulfilled"));
    }

    private void seedCustomerInvoices() {
        List<Long> orderIds = salesOrders.findAll().stream().map(SalesOrder::getId).toList();
        ensureMinimum(customerInvoices, i -> {
            CustomerInvoice invoice = base(new CustomerInvoice(), i, "Demo customer invoice " + twoDigits(i),
                    "Invoice for a community compost order", null, (long) (180 + i * 30), "Unpaid");
            invoice.setSalesOrderId(orderIds.get((i - 1) % orderIds.size()));
            invoice.setCustomer("Community Garden " + twoDigits(i));
            invoice.setInvoiceDate(date(i));
            invoice.setDueDate(date(i - 14));
            return invoice;
        });
    }

    private void seedVendorBills() {
        List<Long> orderIds = purchaseOrders.findAll().stream().map(PurchaseOrder::getId).toList();
        ensureMinimum(vendorBills, i -> {
            VendorBill bill = base(new VendorBill(), i, "Demo vendor bill " + twoDigits(i),
                    "Bill for composting supplies", null, (long) (400 + i * 45), "Pending");
            bill.setPurchaseOrderId(orderIds.get((i - 1) % orderIds.size()));
            bill.setVendor("Green Supply Co. " + twoDigits(i));
            bill.setBillDate(date(i));
            bill.setDueDate(date(i - 30));
            return bill;
        });
    }

    private void seedProcessingBatches() {
        List<Long> digesterIds = digesters.findAll().stream().map(Digester::getId).toList();
        ensureMinimum(processingBatches, i -> {
            ProcessingBatch batch = base(new ProcessingBatch(), i, "Demo processing batch " + twoDigits(i),
                    "Community organic waste converted to compost", decimal(100 + i * 10),
                    (long) (75 + i * 8), "Completed");
            batch.setDigesterId(digesterIds.get((i - 1) % digesterIds.size()));
            batch.setStartDate(date(i));
            batch.setCompletionDate(date(i - 7));
            batch.setInputQuantity(decimal(100 + i * 10));
            batch.setOutputQuantity(decimal(75 + i * 8));
            batch.setAverageTemperature(decimal(35 + i % 5));
            return batch;
        });
    }

    private void seedPayments() {
        ensureMinimum(payments, i -> {
            Payment payment = base(new Payment(), i, "Demo payment " + twoDigits(i),
                    "Sample hub operating transaction", null, (long) (100 + i * 25), "Completed");
            payment.setReference("PAY-DEMO-" + twoDigits(i));
            payment.setMethod(i % 2 == 0 ? "Card" : "Bank Transfer");
            payment.setPaymentDate(date(i));
            payment.setTransactionType(i % 2 == 0 ? "Incoming" : "Outgoing");
            return payment;
        });
    }

    private void seedJournalEntries() {
        ensureMinimum(journalEntries, i -> {
            JournalEntry entry = base(new JournalEntry(), i, "Demo journal entry " + twoDigits(i),
                    "Balanced sample ledger transaction", null, (long) (250 + i * 25), "Posted");
            entry.setAccountCode("AC-" + String.format("%03d", i));
            entry.setDebit(decimal(250 + i * 25));
            entry.setCredit(decimal(250 + i * 25));
            entry.setEntryDate(date(i));
            return entry;
        });
    }

    private <T extends BaseEntity> T base(T entity, int index, String name, String description,
                                          BigDecimal quantity, Long amount, String status) {
        entity.setName(name);
        entity.setDescription(description);
        entity.setQuantity(quantity);
        entity.setAmount(amount == null ? null : decimal(amount));
        entity.setStatus(status);
        return entity;
    }

    private <T> void ensureMinimum(JpaRepository<T, Long> repository, IntFunction<T> recordFactory) {
        long existing = repository.count();
        for (long i = existing + 1; i <= MINIMUM_RECORDS; i++) {
            repository.save(recordFactory.apply((int) i));
        }
    }

    private BigDecimal decimal(long value) {
        return BigDecimal.valueOf(value);
    }

    private LocalDate date(int daysAgo) {
        return LocalDate.now().minusDays(daysAgo);
    }

    private String twoDigits(int value) {
        return String.format("%02d", value);
    }
}
