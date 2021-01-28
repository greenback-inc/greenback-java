package com.greenback.kit.model;

import java.time.Instant;

public class Payment {

    private String relId;
    // credit card vs. bitcoin
    private PaymentMethod method;
    // balance, credit
    private String subMethod;
    // visa, mastercard, etc.
    private PaymentNetwork network;
    // alternative to network, domain indicating who/where (e.g. lowes.com)
    private String domain;
    // account number ends with (such as last 4 digits of card)
    private String endsWith;
    // amount paid
    private Double amount;
    // date of payment
    private Instant paidAt;
    // reference number (if provided)
    private String referenceId;
    // name of the payment method (when present, we will display this in our UI)
    private String name;
    // extra message about the payment
    private String memo;
    
    public Payment copy() {
        Payment copy = new Payment();
        copy.relId = this.relId;
        copy.amount = this.amount;
        copy.endsWith = this.endsWith;
        copy.method = this.method;
        copy.network = this.network;
        copy.domain = this.domain;
        copy.paidAt = this.paidAt;
        copy.referenceId = this.referenceId;
        copy.subMethod = this.subMethod;
        copy.name = this.name;
        copy.memo = this.memo;
        return copy;
    }

    public String getRelId() {
        return relId;
    }

    public Payment setRelId(String relId) {
        this.relId = relId;
        return this;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public Payment setMethod(PaymentMethod method) {
        this.method = method;
        return this;
    }

    public String getSubMethod() {
        return subMethod;
    }

    public Payment setSubMethod(String subMethod) {
        this.subMethod = subMethod;
        return this;
    }
    
    public PaymentNetwork getNetwork() {
        return network;
    }

    public Payment setNetwork(PaymentNetwork network) {
        this.network = network;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public Payment setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    
    public String getEndsWith() {
        return endsWith;
    }

    public Payment setEndsWith(String endsWith) {
        this.endsWith = endsWith;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Payment setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
    
    public Instant getPaidAt() {
        return paidAt;
    }
    
    public Payment setPaidAt(Instant paidAt) {
        this.paidAt = paidAt;
        return this;
    }
    
    public String getReferenceId() {
        return referenceId;
    }
    
    public Payment setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Payment setName(String name) {
        this.name = name;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public Payment setMemo(String memo) {
        this.memo = memo;
        return this;
    }
    
}