package com.greenback.kit.model;

import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;

public class DocumentQuery<T> extends Query<T> {
    
    protected Set<DocumentFlag> flags;
    protected Set<String> accountIds;
    
    public Iterable<DocumentFlag> getFlags() {
        return this.flags;
    }

    @SuppressWarnings("unchecked")
    public T setFlags(Iterable<DocumentFlag> flags) {
        if (flags == null) {
            this.flags = null;
        }
        else {
            this.flags = new HashSet<>();
            flags.forEach(v -> this.flags.add(v));
        }
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setFlags(DocumentFlag... flag) {
        this.flags = new HashSet<>(asList(flag));
        return (T)this;
    }
    
    public Iterable<String> getAccountIds() {
        return this.accountIds;
    }

    @SuppressWarnings("unchecked")
    public T setAccountIds(Iterable<String> accountIds) {
        if (accountIds == null) {
            this.accountIds = null;
        }
        else {
            this.accountIds = new HashSet<>();
            accountIds.forEach(v -> this.accountIds.add(v));
        }
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setAccountIds(String... accountId) {
        this.accountIds = new HashSet<>(asList(accountId));
        return (T)this;
    }
    
    // helpers
    
    @SuppressWarnings({"unchecked", "unchecked"})
    public T addFlag(DocumentFlag... flag) {
        if (this.flags == null) {
            this.flags = new HashSet<>();
        }
        if (flag != null) {
            this.flags.addAll(asList(flag));
        }
        return (T)this;
    } 
    
    @SuppressWarnings("unchecked")
    public T addAccountId(String... accountId) {
        if (this.accountIds == null) {
            this.accountIds = new HashSet<>();
        }
        if (accountId != null) {
            this.accountIds.addAll(asList(accountId));
        }
        return (T)this;
    }
    
}