package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "processing_batch")
public class ProcessingBatch extends BaseEntity {
    private Long digesterId;
    private java.time.LocalDate startDate;
    private java.time.LocalDate completionDate;
    private java.math.BigDecimal inputQuantity;
    private java.math.BigDecimal outputQuantity;
    private java.math.BigDecimal averageTemperature;

    public Long getDigesterId() { return digesterId; }
    public void setDigesterId(Long digesterId) { this.digesterId = digesterId; }
    public java.time.LocalDate getStartDate() { return startDate; }
    public void setStartDate(java.time.LocalDate startDate) { this.startDate = startDate; }
    public java.time.LocalDate getCompletionDate() { return completionDate; }
    public void setCompletionDate(java.time.LocalDate completionDate) { this.completionDate = completionDate; }
    public java.math.BigDecimal getInputQuantity() { return inputQuantity; }
    public void setInputQuantity(java.math.BigDecimal inputQuantity) { this.inputQuantity = inputQuantity; }
    public java.math.BigDecimal getOutputQuantity() { return outputQuantity; }
    public void setOutputQuantity(java.math.BigDecimal outputQuantity) { this.outputQuantity = outputQuantity; }
    public java.math.BigDecimal getAverageTemperature() { return averageTemperature; }
    public void setAverageTemperature(java.math.BigDecimal averageTemperature) { this.averageTemperature = averageTemperature; }
}
