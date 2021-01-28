package com.greenback.kit.model;

import java.time.Instant;

public class TransactionStatus {

    private TransactionState state;
    private String message;
    private Instant updatedAt;

    public TransactionState getState() {
        return state;
    }

    public TransactionStatus setState(TransactionState state) {
        this.state = state;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public TransactionStatus setMessage(String message) {
        this.message = message;
        return this;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public TransactionStatus setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
    
}