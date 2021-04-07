package com.greenback.kit.model;

import java.util.List;

public class TransactionTotals {
 
    private Double sub;
    private Double fee;
    private Double discount;
    private Double ship;
    private Double tip;
    private Double tax;
    private Double other;
    private List<TotalsItem> items;
    private Double grand;
    
    public Double getSub() {
        return sub;
    }

    public TransactionTotals setSub(Double sub) {
        this.sub = sub;
        return this;
    }

    public Double getFee() {
        return fee;
    }

    public TransactionTotals setFee(Double fee) {
        this.fee = fee;
        return this;
    }

    public Double getDiscount() {
        return discount;
    }

    public TransactionTotals setDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    public Double getShip() {
        return ship;
    }

    public TransactionTotals setShip(Double ship) {
        this.ship = ship;
        return this;
    }

    public Double getTip() {
        return tip;
    }

    public TransactionTotals setTip(Double tip) {
        this.tip = tip;
        return this;
    }

    public Double getTax() {
        return tax;
    }

    public TransactionTotals setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public Double getOther() {
        return other;
    }

    public TransactionTotals setOther(Double other) {
        this.other = other;
        return this;
    }

    public Double getGrand() {
        return grand;
    }

    public TransactionTotals setGrand(Double grand) {
        this.grand = grand;
        return this;
    }

    public List<TotalsItem> getItems() {
        return items;
    }

    public TransactionTotals setItems(List<TotalsItem> items) {
        this.items = items;
        return this;
    }

}