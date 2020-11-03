package com.greenback.kit.model;

import java.util.List;

public class Item {
 
    private String grn;
    private List<String> altGrns;
    private String name;
    private String description;
    private Double quantity;
    private Double unitPrice;
    private Double amount;

    public String getGrn() {
        return grn;
    }

    public void setGrn(String grn) {
        this.grn = grn;
    }

    public List<String> getAltGrns() {
        return altGrns;
    }

    public void setAltGrns(List<String> altGrns) {
        this.altGrns = altGrns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}