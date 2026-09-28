package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_order")
public class SalesOrder extends BaseEntity {
    private String customer;
    private java.time.LocalDate orderDate;
    private java.time.LocalDate dueDate;

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }
    public java.time.LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(java.time.LocalDate orderDate) { this.orderDate = orderDate; }
    public java.time.LocalDate getDueDate() { return dueDate; }
    public void setDueDate(java.time.LocalDate dueDate) { this.dueDate = dueDate; }
}
