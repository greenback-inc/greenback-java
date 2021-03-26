package com.greenback.kit.model;

public class Sync extends GreenbackObject {
 
    private String referenceId;
    private String accountId;
    private SyncType type;
    private String triggeredBy;
    private String message;
    private Double progress;
    private ProcessingStatus status;
    private GreenbackError error;
    private SyncRequest request;
    private SyncSummary summary;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public ProcessingStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessingStatus status) {
        this.status = status;
    }
    
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public SyncType getType() {
        return type;
    }

    public void setType(SyncType type) {
        this.type = type;
    }

    public String getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(String triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public GreenbackError getError() {
        return error;
    }

    public void setError(GreenbackError error) {
        this.error = error;
    }

    public SyncSummary getSummary() {
        return summary;
    }

    public void setSummary(SyncSummary summary) {
        this.summary = summary;
    }

    public SyncRequest getRequest() {
        return request;
    }

    public void setRequest(SyncRequest request) {
        this.request = request;
    }

}