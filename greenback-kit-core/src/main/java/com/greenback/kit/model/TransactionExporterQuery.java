package com.greenback.kit.model;

import java.time.Instant;

public class TransactionExporterQuery extends Query<TransactionExporterQuery> {
    
    protected String payment;
    protected Boolean itemized;
    protected Instant verifiedBy;

    public String getPayment() {
        return payment;
    }

    public TransactionExporterQuery setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public Boolean getItemized() {
        return itemized;
    }

    public TransactionExporterQuery setItemized(Boolean itemized) {
        this.itemized = itemized;
        return this;
    }

    public Instant getVerifiedBy() {
        return verifiedBy;
    }

    public TransactionExporterQuery setVerifiedBy(Instant verifiedBy) {
        this.verifiedBy = verifiedBy;
        return this;
    }
    
}