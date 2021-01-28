package com.greenback.kit.model;

import java.time.Instant;
import java.util.List;

public class Transaction extends Document {
 
    private TransactionType type;
    private String currencyCode;
    private String displayReferenceId;
    private String accountId;
    private String contactId;
    private TransactionStatus status;
    private List<Attachment> attachments;
    private PostalAddress billingAddress;
    private PostalAddress shippingAddress;
    private PostalAddress storeAddress;
    private List<Item> items;
    private List<Payment> payments;
    private List<Payment> deposits;
    private List<ExchangeRate> exchangeRates;
    private TransactionTotals totals;
    private Instant transactedAt;
    private Instant dueAt;
    
    // expandable
    private Account account;
    private Contact contact;
    private TransactionExport export;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDisplayReferenceId() {
        return displayReferenceId;
    }

    public void setDisplayReferenceId(String displayReferenceId) {
        this.displayReferenceId = displayReferenceId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public PostalAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(PostalAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PostalAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(PostalAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PostalAddress getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(PostalAddress storeAddress) {
        this.storeAddress = storeAddress;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Payment> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Payment> deposits) {
        this.deposits = deposits;
    }

    public TransactionTotals getTotals() {
        return totals;
    }

    public void setTotals(TransactionTotals totals) {
        this.totals = totals;
    }

    public Instant getTransactedAt() {
        return transactedAt;
    }

    public void setTransactedAt(Instant transactedAt) {
        this.transactedAt = transactedAt;
    }

    public Instant getDueAt() {
        return dueAt;
    }

    public void setDueAt(Instant dueAt) {
        this.dueAt = dueAt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public TransactionExport getExport() {
        return export;
    }

    public void setExport(TransactionExport export) {
        this.export = export;
    }

}