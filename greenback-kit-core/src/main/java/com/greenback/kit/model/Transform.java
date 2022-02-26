package com.greenback.kit.model;

public class Transform extends GreenbackObject {
 
    private String accountId;
    private Long sortOrder;
    private TransformType type;
    private TransformState state;
    private String name;
    private Object matcher;
    private Object methods;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public TransformType getType() {
        return type;
    }

    public void setType(TransformType type) {
        this.type = type;
    }

    public TransformState getState() {
        return state;
    }

    public void setState(TransformState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getMatcher() {
        return matcher;
    }

    public void setMatcher(Object matcher) {
        this.matcher = matcher;
    }

    public Object getMethods() {
        return methods;
    }

    public void setMethods(Object methods) {
        this.methods = methods;
    }

}