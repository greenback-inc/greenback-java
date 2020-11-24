package com.greenback.kit.model;

import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;

public class Query<T> {
 
    protected Integer limit;
    protected Set<String> expands;

    public Integer getLimit() {
        return limit;
    }

    @SuppressWarnings("unchecked")
    public T setLimit(Integer limit) {
        this.limit = limit;
        return (T)this;
    }
    
    public Iterable<String> getExpands() {
        return this.expands;
    }

    @SuppressWarnings("unchecked")
    public T setExpands(Iterable<String> expands) {
        if (expands == null) {
            this.expands = null;
        }
        else {
            this.expands = new HashSet<>();
            expands.forEach(v -> this.expands.add(v));
        }
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setExpands(String... expand) {
        this.expands = new HashSet<>(asList(expand));
        return (T)this;
    }
    
    // helpers
    
    @SuppressWarnings("unchecked")
    public T addExpand(String... expand) {
        if (this.expands == null) {
            this.expands = new HashSet<>();
        }
        if (expand != null) {
            this.expands.addAll(asList(expand));
        }
        return (T)this;
    }
    
}