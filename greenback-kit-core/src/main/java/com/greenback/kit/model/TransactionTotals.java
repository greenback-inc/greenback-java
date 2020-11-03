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

    public void setSub(Double sub) {
        this.sub = sub;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getShip() {
        return ship;
    }

    public void setShip(Double ship) {
        this.ship = ship;
    }

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getGrand() {
        return grand;
    }

    public void setGrand(Double grand) {
        this.grand = grand;
    }

    public List<TotalsItem> getItems() {
        return items;
    }

    public void setItems(List<TotalsItem> items) {
        this.items = items;
    }

}