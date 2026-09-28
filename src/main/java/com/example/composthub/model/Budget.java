package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "budget")
public class Budget extends BaseEntity {
    private String period;
    private java.math.BigDecimal plannedAmount;
    private java.math.BigDecimal actualAmount;

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
    public java.math.BigDecimal getPlannedAmount() { return plannedAmount; }
    public void setPlannedAmount(java.math.BigDecimal plannedAmount) { this.plannedAmount = plannedAmount; }
    public java.math.BigDecimal getActualAmount() { return actualAmount; }
    public void setActualAmount(java.math.BigDecimal actualAmount) { this.actualAmount = actualAmount; }
}
