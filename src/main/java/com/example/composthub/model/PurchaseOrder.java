package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder extends BaseEntity {
    private String vendor;
    private java.time.LocalDate orderDate;
    private java.time.LocalDate dueDate;

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }
    public java.time.LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(java.time.LocalDate orderDate) { this.orderDate = orderDate; }
    public java.time.LocalDate getDueDate() { return dueDate; }
    public void setDueDate(java.time.LocalDate dueDate) { this.dueDate = dueDate; }
}
