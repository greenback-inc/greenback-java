package com.greenback.kit.model;

import java.time.Instant;
import java.util.Objects;

public class Settlement {
    /**
     * NOTE: Critical all properties are included in equals() and hashCode()
     */
    
    private String id;
    private Double amount;
    private Instant estimatedDepositAt;

    public String getId() {
        return id;
    }

    public Settlement setId(String id) {
        this.id = id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Settlement setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Instant getEstimatedDepositAt() {
        return estimatedDepositAt;
    }

    public Settlement setEstimatedDepositAt(Instant estimatedDepositAt) {
        this.estimatedDepositAt = estimatedDepositAt;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Settlement other = (Settlement) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (this.estimatedDepositAt != other.estimatedDepositAt) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7 * Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.amount);
        hash = 37 * hash + Objects.hashCode(this.estimatedDepositAt);
        return hash;
    }
}
