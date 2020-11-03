package com.greenback.kit.model;

import java.util.Iterator;
import java.util.List;
import static java.util.Optional.ofNullable;

public class Paginated<T> extends Response implements Iterable<T> {
 
    private Pagination pagination;
    private List<T> values;
    
    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
    
    public String getNext() {
        return ofNullable(this.pagination)
            .map(v -> v.getNext())
            .orElse(null);
    }
    
    public boolean hasNext() {
        return ofNullable(this.pagination)
            .map(v -> v.getNext())
            .isPresent();
    }

    @Override
    public Iterator<T> iterator() {
        return this.getValues().iterator();
    }
    
}