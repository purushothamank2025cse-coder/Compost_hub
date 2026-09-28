package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
    private String reference;
    private String method;
    private java.time.LocalDate paymentDate;
    private String transactionType;

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public java.time.LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(java.time.LocalDate paymentDate) { this.paymentDate = paymentDate; }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
}
