package com.greenback.kit.util;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Utils {
    
    static public String toStringList(Iterable<?> values) {
        final StringBuilder sb = new StringBuilder();
        
        if (values != null) {
            for (Object v : values) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(Objects.toString(v, ""));
            }
        }
        
        return sb.toString();
    }
    
    @SuppressWarnings("unchecked")
    static public <T> Iterable<T> appendIterable(Iterable<T> values, T value) {
        Objects.requireNonNull(value, "value was null");
        
        if (values == null) {
            values = new ArrayList<>();
        }
        
        if (values instanceof Collection) {
            // add the value
            ((Collection)values).add(value);
        } else {
            throw new IllegalArgumentException("Values was not an instanceof a Collection");
        }
        
        return values;
    }
    
    @SafeVarargs
    @SuppressWarnings("varargs")
    static public <T> Iterable<T> toIterable(T... values) {
        if (values == null) {
            return null;
        } else {
            return asList(values);
        }
    }
 
    static public <T> Set<T> toSet(Iterable<T> values) {
        if (values == null) {
            return null;
        }
        else {
            Set<T> newValues = new HashSet<>();
            values.forEach(v -> newValues.add(v));
            return newValues;
        }
    }
    
}