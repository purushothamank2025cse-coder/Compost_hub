package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity {
    private String unit;
    private String productType;
    private java.math.BigDecimal reorderLevel;

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }
    public java.math.BigDecimal getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(java.math.BigDecimal reorderLevel) { this.reorderLevel = reorderLevel; }
}
