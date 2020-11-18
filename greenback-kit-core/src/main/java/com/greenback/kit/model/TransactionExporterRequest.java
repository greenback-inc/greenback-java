package com.greenback.kit.model;

import java.time.Instant;
import java.util.Map;

public class TransactionExporterRequest {
 
    private String payment;
    private Boolean itemized;
    private Instant verifiedBy;
    private Map<String,String> parameters;

    public String getPayment() {
        return payment;
    }

    public TransactionExporterRequest setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public Boolean getItemized() {
        return itemized;
    }

    public TransactionExporterRequest setItemized(Boolean itemized) {
        this.itemized = itemized;
        return this;
    }

    public Instant getVerifiedBy() {
        return verifiedBy;
    }

    public TransactionExporterRequest setVerifiedBy(Instant verifiedBy) {
        this.verifiedBy = verifiedBy;
        return this;
    }
    
    public Map<String, String> getParameters() {
        return parameters;
    }

    public TransactionExporterRequest setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }
    
}