package com.greenback.kit.model;

public class TotalsItem {
    
    private TotalsItemType type;
    private String name;
    private Double amount;

    public TotalsItemType getType() {
        return type;
    }

    public void setType(TotalsItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}