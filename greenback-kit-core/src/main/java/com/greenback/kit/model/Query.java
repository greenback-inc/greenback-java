package com.greenback.kit.model;

import static com.greenback.kit.util.Utils.toIterable;

public class Query<T> {
 
    protected Integer limit;
    protected Iterable<String> expands;

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
        this.expands = expands;
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setExpands(String... expands) {
        this.expands = toIterable(expands);
        return (T)this;
    }
    
}