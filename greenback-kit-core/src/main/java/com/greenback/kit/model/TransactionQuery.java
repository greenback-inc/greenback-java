package com.greenback.kit.model;

import static com.greenback.kit.util.Utils.toIterable;
import java.time.Instant;

public class TransactionQuery extends DocumentQuery<TransactionQuery> {
    
    protected Iterable<TransactionType> types;
    protected String query;
    protected Instant minTransactedAt;
    protected Instant maxTransactedAt;
    protected Boolean descending;

    public Iterable<TransactionType> getTypes() {
        return this.types;
    }

    public TransactionQuery setTypes(Iterable<TransactionType> types) {
        this.types = types;
        return this;
    }

    public TransactionQuery setTypes(TransactionType... types) {
        this.types = toIterable(types);
        return this;
    }
    
    public String getQuery() {
        return query;
    }

    public TransactionQuery setQuery(String query) {
        this.query = query;
        return this;
    }

    public Instant getMinTransactedAt() {
        return minTransactedAt;
    }

    public TransactionQuery setMinTransactedAt(Instant minTransactedAt) {
        this.minTransactedAt = minTransactedAt;
        return this;
    }

    public Instant getMaxTransactedAt() {
        return maxTransactedAt;
    }

    public TransactionQuery setMaxTransactedAt(Instant maxTransactedAt) {
        this.maxTransactedAt = maxTransactedAt;
        return this;
    }

    public Boolean getDescending() {
        return descending;
    }

    public TransactionQuery setDescending(Boolean descending) {
        this.descending = descending;
        return this;
    }
    
}