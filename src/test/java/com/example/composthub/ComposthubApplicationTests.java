package com.example.composthub;

import com.example.composthub.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ComposthubApplicationTests {

	@Autowired private AccountRepository accounts;
	@Autowired private BudgetRepository budgets;
	@Autowired private BudgetLineRepository budgetLines;
	@Autowired private ContactRepository contacts;
	@Autowired private CustomerInvoiceRepository customerInvoices;
	@Autowired private DigesterRepository digesters;
	@Autowired private InventoryRepository inventory;
	@Autowired private JournalEntryRepository journalEntries;
	@Autowired private PaymentRepository payments;
	@Autowired private ProcessingBatchRepository processingBatches;
	@Autowired private ProductRepository products;
	@Autowired private PurchaseOrderRepository purchaseOrders;
	@Autowired private PurchaseOrderItemRepository purchaseOrderItems;
	@Autowired private SalesOrderRepository salesOrders;
	@Autowired private SalesOrderItemRepository salesOrderItems;
	@Autowired private VendorBillRepository vendorBills;
	@Autowired private WasteIntakeRepository wasteIntakes;

	@Test
	void contextLoads() {
		assertThat(accounts.count()).isGreaterThanOrEqualTo(10);
		assertThat(budgets.count()).isGreaterThanOrEqualTo(10);
		assertThat(budgetLines.count()).isGreaterThanOrEqualTo(10);
		assertThat(contacts.count()).isGreaterThanOrEqualTo(10);
		assertThat(customerInvoices.count()).isGreaterThanOrEqualTo(10);
		assertThat(digesters.count()).isGreaterThanOrEqualTo(10);
		assertThat(inventory.count()).isGreaterThanOrEqualTo(10);
		assertThat(journalEntries.count()).isGreaterThanOrEqualTo(10);
		assertThat(payments.count()).isGreaterThanOrEqualTo(10);
		assertThat(processingBatches.count()).isGreaterThanOrEqualTo(10);
		assertThat(products.count()).isGreaterThanOrEqualTo(10);
		assertThat(purchaseOrders.count()).isGreaterThanOrEqualTo(10);
		assertThat(purchaseOrderItems.count()).isGreaterThanOrEqualTo(10);
		assertThat(salesOrders.count()).isGreaterThanOrEqualTo(10);
		assertThat(salesOrderItems.count()).isGreaterThanOrEqualTo(10);
		assertThat(vendorBills.count()).isGreaterThanOrEqualTo(10);
		assertThat(wasteIntakes.count()).isGreaterThanOrEqualTo(10);
	}

}
