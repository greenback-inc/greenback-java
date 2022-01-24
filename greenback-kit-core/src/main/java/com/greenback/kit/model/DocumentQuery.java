package com.greenback.kit.model;

import static com.greenback.kit.util.Utils.appendIterable;
import static com.greenback.kit.util.Utils.toIterable;
import java.time.Instant;

public class DocumentQuery<T> extends Query<T> {
    
    protected DocumentSourceKind sourceKind;
    protected Iterable<DocumentFlag> flags;
    protected Iterable<String> accountIds;
    protected Instant minCreatedAt;
    protected Instant maxCreatedAt;
    protected Instant minUpdatedAt;
    protected Instant maxUpdatedAt;

    public DocumentSourceKind getSourceKind() {
        return sourceKind;
    }

    @SuppressWarnings("unchecked")
    public T setSourceKind(DocumentSourceKind sourceKind) {
        this.sourceKind = sourceKind;
        return (T)this;
    }

    public Iterable<DocumentFlag> getFlags() {
        return this.flags;
    }

    @SuppressWarnings("unchecked")
    public T setFlags(Iterable<DocumentFlag> flags) {
        this.flags = flags;
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setFlags(DocumentFlag... flags) {
        this.flags = toIterable(flags);
        return (T)this;
    }
    
    public Iterable<String> getAccountIds() {
        return this.accountIds;
    }

    @SuppressWarnings("unchecked")
    public T setAccountIds(Iterable<String> accountIds) {
        this.accountIds = accountIds;
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setAccountIds(String... accountIds) {
        this.accountIds = toIterable(accountIds);
        return (T)this;
    }

    public Instant getMinCreatedAt() {
        return minCreatedAt;
    }

    @SuppressWarnings("unchecked")
    public T setMinCreatedAt(Instant minCreatedAt) {
        this.minCreatedAt = minCreatedAt;
        return (T)this;
    }

    public Instant getMaxCreatedAt() {
        return maxCreatedAt;
    }

    @SuppressWarnings("unchecked")
    public T setMaxCreatedAt(Instant maxCreatedAt) {
        this.maxCreatedAt = maxCreatedAt;
        return (T)this;
    }

    public Instant getMinUpdatedAt() {
        return minUpdatedAt;
    }

    @SuppressWarnings("unchecked")
    public T setMinUpdatedAt(Instant minUpdatedAt) {
        this.minUpdatedAt = minUpdatedAt;
        return (T)this;
    }

    public Instant getMaxUpdatedAt() {
        return maxUpdatedAt;
    }

    @SuppressWarnings("unchecked")
    public T setMaxUpdatedAt(Instant maxUpdatedAt) {
        this.maxUpdatedAt = maxUpdatedAt;
        return (T)this;
    }

    // helpers
    
    @SuppressWarnings("unchecked")
    public T addFlag(DocumentFlag flag) {
        this.flags = appendIterable(this.flags, flag);
        return (T)this;
    } 
    
    @SuppressWarnings("unchecked")
    public T addAccountId(String accountId) {
        this.accountIds = appendIterable(this.accountIds, accountId);
        return (T)this;
    }
    
}