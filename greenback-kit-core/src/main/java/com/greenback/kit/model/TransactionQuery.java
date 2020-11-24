package com.greenback.kit.model;

import java.time.Instant;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;

public class TransactionQuery extends DocumentQuery<TransactionQuery> {
    
    protected Set<TransactionType> types;
    protected String query;
    protected Instant minTransactedAt;          // start
    protected Instant maxTransactedAt;          // end

    public Iterable<TransactionType> getTypes() {
        return this.types;
    }

    public TransactionQuery setTypes(Iterable<TransactionType> types) {
        if (types == null) {
            this.types = null;
        }
        else {
            this.types = new HashSet<>();
            types.forEach(v -> this.types.add(v));
        }
        return this;
    }

    public TransactionQuery setTypes(TransactionType... type) {
        this.types = new HashSet<>(asList(type));
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
    
    // helpers
    
    public TransactionQuery addType(TransactionType... type) {
        if (this.types == null) {
            this.types = new HashSet<>();
        }
        if (type != null) {
            this.types.addAll(asList(type));
        }
        return this;
    } 
    
}