package com.greenback.kit.model;

public class TotalsItem {
    
    private TotalsItemType type;
    private String name;
    private Double amount;
    private String taxGrn;

    public TotalsItemType getType() {
        return type;
    }

    public TotalsItem setType(TotalsItemType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public TotalsItem setName(String name) {
        this.name = name;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public TotalsItem setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getTaxGrn() {
        return taxGrn;
    }

    public TotalsItem setTaxGrn(String taxGrn) {
        this.taxGrn = taxGrn;
        return this;
    }
    
}