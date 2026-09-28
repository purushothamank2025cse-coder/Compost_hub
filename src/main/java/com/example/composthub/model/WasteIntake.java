package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "waste_intake")
public class WasteIntake extends BaseEntity {
    private String source;
    private java.time.LocalDate intakeDate;
    private String materialType;

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public java.time.LocalDate getIntakeDate() { return intakeDate; }
    public void setIntakeDate(java.time.LocalDate intakeDate) { this.intakeDate = intakeDate; }
    public String getMaterialType() { return materialType; }
    public void setMaterialType(String materialType) { this.materialType = materialType; }
}
