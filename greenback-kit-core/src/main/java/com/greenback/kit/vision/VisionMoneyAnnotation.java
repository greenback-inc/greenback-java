package com.greenback.kit.vision;

public class VisionMoneyAnnotation extends VisionAnnotation {
    
    private String currencyCode;
    private String symbol;
    private Double amount;
    private String code;

    @Override
    public String getType() {
        return "money";
    }
    
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}