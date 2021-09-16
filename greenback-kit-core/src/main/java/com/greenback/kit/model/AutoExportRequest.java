package com.greenback.kit.model;

import java.time.Instant;
import java.util.List;

public class AutoExportRequest {
    private String query;
    private List<TransactionType> types;
    private Instant minTransactedAt;
    private Instant maxTransactedAt;
    private Integer limit;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<TransactionType> getTypes() {
        return types;
    }

    public void setTypes(List<TransactionType> types) {
        this.types = types;
    }

    public Instant getMinTransactedAt() {
        return minTransactedAt;
    }

    public void setMinTransactedAt(Instant minTransactedAt) {
        this.minTransactedAt = minTransactedAt;
    }

    public Instant getMaxTransactedAt() {
        return maxTransactedAt;
    }

    public void setMaxTransactedAt(Instant maxTransactedAt) {
        this.maxTransactedAt = maxTransactedAt;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "AutoExportRequest{" +
            "query='" + query + '\'' +
            ", types=" + types +
            ", minTransactedAt=" + minTransactedAt +
            ", maxTransactedAt=" + maxTransactedAt +
            ", limit=" + limit +
            '}';
    }
}
