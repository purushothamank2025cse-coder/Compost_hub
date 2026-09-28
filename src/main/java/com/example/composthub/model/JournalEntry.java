package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "journal_entry")
public class JournalEntry extends BaseEntity {
    private String accountCode;
    private java.math.BigDecimal debit;
    private java.math.BigDecimal credit;
    private java.time.LocalDate entryDate;

    public String getAccountCode() { return accountCode; }
    public void setAccountCode(String accountCode) { this.accountCode = accountCode; }
    public java.math.BigDecimal getDebit() { return debit; }
    public void setDebit(java.math.BigDecimal debit) { this.debit = debit; }
    public java.math.BigDecimal getCredit() { return credit; }
    public void setCredit(java.math.BigDecimal credit) { this.credit = credit; }
    public java.time.LocalDate getEntryDate() { return entryDate; }
    public void setEntryDate(java.time.LocalDate entryDate) { this.entryDate = entryDate; }
}
