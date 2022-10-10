package com.greenback.kit.model;

import java.util.List;
import java.util.Map;

public class Item {
 
    private String grn;
    private List<String> altGrns;
    private String name;
    private String description;
    private Double quantity;
    private Double unitPrice;
    private Double amount;
    private String taxGrn;
    protected Map<String,String> attributes;

    public String getGrn() {
        return grn;
    }

    public Item setGrn(String grn) {
        this.grn = grn;
        return this;
    }

    public List<String> getAltGrns() {
        return altGrns;
    }

    public Item setAltGrns(List<String> altGrns) {
        this.altGrns = altGrns;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Item setQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Item setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Item setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getTaxGrn() {
        return taxGrn;
    }

    public Item setTaxGrn(String taxGrn) {
        this.taxGrn = taxGrn;
        return this;
    }

    public Map<String,String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String,String> attributes) {
        this.attributes = attributes;
    }
}