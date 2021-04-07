package com.greenback.kit.model;

public class TransactionExportStep {
 
    protected ExportType type;
    protected ExportAction action;
    protected String sourceId;
    protected Double sourceAmount;
    protected String targetId;
    protected Double targetAmount;

    public ExportType getType() {
        return type;
    }

    public void setType(ExportType type) {
        this.type = type;
    }

    public ExportAction getAction() {
        return action;
    }

    public void setAction(ExportAction action) {
        this.action = action;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(Double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

}