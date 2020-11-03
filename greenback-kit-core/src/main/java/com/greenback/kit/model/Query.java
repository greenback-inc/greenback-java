package com.greenback.kit.model;

import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.joining;

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
    
    public Set<String> getExpands() {
        return expands;
    }

    @SuppressWarnings("unchecked")
    public T setExpands(Set<String> expands) {
        this.expands = expands;
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
            for (String v : expand) {
                this.expands.add(v);
            }
        }
        return (T)this;
    }
    
    public String toParameter() {
        if (this.expands == null || this.expands.isEmpty()) {
            return null;
        }
        return this.expands.stream()
            .collect(joining(","));
    }
    
}