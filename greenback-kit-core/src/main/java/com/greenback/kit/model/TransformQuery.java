package com.greenback.kit.model;

import java.time.Instant;

public class TransformQuery extends Query<TransformQuery> {

    protected Iterable<String> accountIds;
    protected Iterable<TransformState> states;
    protected Instant minCreatedAt;
    protected Instant maxCreatedAt;
    protected Instant minUpdatedAt;
    protected Instant maxUpdatedAt;

    public Iterable<String> getAccountIds() {
        return accountIds;
    }

    public TransformQuery setAccountIds(Iterable<String> accountIds) {
        this.accountIds = accountIds;
        return this;
    }

    public Iterable<TransformState> getStates() {
        return states;
    }

    public TransformQuery setStates(Iterable<TransformState> states) {
        this.states = states;
        return this;
    }

    public Instant getMinCreatedAt() {
        return minCreatedAt;
    }

    public TransformQuery setMinCreatedAt(Instant minCreatedAt) {
        this.minCreatedAt = minCreatedAt;
        return this;
    }

    public Instant getMaxCreatedAt() {
        return maxCreatedAt;
    }

    public TransformQuery setMaxCreatedAt(Instant maxCreatedAt) {
        this.maxCreatedAt = maxCreatedAt;
        return this;
    }

    public Instant getMinUpdatedAt() {
        return minUpdatedAt;
    }

    public TransformQuery setMinUpdatedAt(Instant minUpdatedAt) {
        this.minUpdatedAt = minUpdatedAt;
        return this;
    }

    public Instant getMaxUpdatedAt() {
        return maxUpdatedAt;
    }

    public TransformQuery setMaxUpdatedAt(Instant maxUpdatedAt) {
        this.maxUpdatedAt = maxUpdatedAt;
        return this;
    }

}