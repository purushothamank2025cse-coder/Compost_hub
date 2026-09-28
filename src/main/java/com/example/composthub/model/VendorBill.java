package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_bill")
public class VendorBill extends BaseEntity {
    private Long purchaseOrderId;
    private String vendor;
    private java.time.LocalDate billDate;
    private java.time.LocalDate dueDate;

    public Long getPurchaseOrderId() { return purchaseOrderId; }
    public void setPurchaseOrderId(Long purchaseOrderId) { this.purchaseOrderId = purchaseOrderId; }
    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }
    public java.time.LocalDate getBillDate() { return billDate; }
    public void setBillDate(java.time.LocalDate billDate) { this.billDate = billDate; }
    public java.time.LocalDate getDueDate() { return dueDate; }
    public void setDueDate(java.time.LocalDate dueDate) { this.dueDate = dueDate; }
}
