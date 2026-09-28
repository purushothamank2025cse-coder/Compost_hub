package com.example.composthub.controller;

import com.example.composthub.model.*;
import com.example.composthub.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/compost")
public class TransactionController {
    private final PurchaseOrderService purchases;
    private final SalesOrderService sales;
    private final VendorBillService bills;
    private final CustomerInvoiceService invoices;
    private final PaymentService payments;

    public TransactionController(PurchaseOrderService purchases, SalesOrderService sales,
                                 VendorBillService bills, CustomerInvoiceService invoices,
                                 PaymentService payments) {
        this.purchases = purchases;
        this.sales = sales;
        this.bills = bills;
        this.invoices = invoices;
        this.payments = payments;
    }

    @PostMapping("/purchases/{id}/bill")
    @ResponseStatus(HttpStatus.CREATED)
    public VendorBill convertPurchaseToBill(@PathVariable Long id) {
        PurchaseOrder order = purchases.findById(id);
        VendorBill bill = new VendorBill();
        bill.setName("Bill for PO-" + id);
        bill.setPurchaseOrderId(id);
        bill.setVendor(order.getVendor());
        bill.setAmount(order.getAmount());
        bill.setBillDate(LocalDate.now());
        bill.setDueDate(order.getDueDate());
        bill.setStatus("Open");
        return bills.save(bill);
    }

    @PostMapping("/sales/{id}/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerInvoice convertSaleToInvoice(@PathVariable Long id) {
        SalesOrder order = sales.findById(id);
        CustomerInvoice invoice = new CustomerInvoice();
        invoice.setName("Invoice for SO-" + id);
        invoice.setSalesOrderId(id);
        invoice.setCustomer(order.getCustomer());
        invoice.setAmount(order.getAmount());
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setDueDate(order.getDueDate());
        invoice.setStatus("Open");
        return invoices.save(invoice);
    }

    @PostMapping("/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment recordPayment(@RequestBody Payment payment) {
        if (payment.getAmount() == null || payment.getAmount().signum() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        if (payment.getPaymentDate() == null) payment.setPaymentDate(LocalDate.now());
        if (payment.getStatus() == null || payment.getStatus().isBlank()) payment.setStatus("Posted");
        return payments.save(payment);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WasteIntakeController.ErrorResponse badRequest(IllegalArgumentException exception) {
        return new WasteIntakeController.ErrorResponse(exception.getMessage());
    }
}
