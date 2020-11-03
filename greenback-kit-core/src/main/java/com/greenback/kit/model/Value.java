package com.greenback.kit.model;

public class Value<T> extends Response {
 
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
}