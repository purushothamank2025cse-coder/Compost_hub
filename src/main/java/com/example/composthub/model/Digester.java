package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "digester")
public class Digester extends BaseEntity {
    private java.math.BigDecimal targetTemperature;
    private java.math.BigDecimal currentTemperature;
    private String sensorId;

    public java.math.BigDecimal getTargetTemperature() { return targetTemperature; }
    public void setTargetTemperature(java.math.BigDecimal value) { this.targetTemperature = value; }
    public java.math.BigDecimal getCurrentTemperature() { return currentTemperature; }
    public void setCurrentTemperature(java.math.BigDecimal value) { this.currentTemperature = value; }
    public String getSensorId() { return sensorId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }
}
