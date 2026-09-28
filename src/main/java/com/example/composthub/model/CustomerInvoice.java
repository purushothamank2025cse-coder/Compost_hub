package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_invoice")
public class CustomerInvoice extends BaseEntity {
    private Long salesOrderId;
    private String customer;
    private java.time.LocalDate invoiceDate;
    private java.time.LocalDate dueDate;

    public Long getSalesOrderId() { return salesOrderId; }
    public void setSalesOrderId(Long salesOrderId) { this.salesOrderId = salesOrderId; }
    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }
    public java.time.LocalDate getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(java.time.LocalDate invoiceDate) { this.invoiceDate = invoiceDate; }
    public java.time.LocalDate getDueDate() { return dueDate; }
    public void setDueDate(java.time.LocalDate dueDate) { this.dueDate = dueDate; }
}
