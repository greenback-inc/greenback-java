package com.greenback.kit.model;

import java.time.Instant;

public class Lambda {
    private Long id;
    private String referenceId;
    private LambdaType type;
    private ProcessingStatus status;
    private String userId;
    private Long typeTagId;
    private String lockedBy;
    private String hostname;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant killedAt;
    private Instant completedAt;
    private Double progress;
    private String message;
    private String parametersDoc;
    private String resultsDoc;
    private TriggeredBy triggeredBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public LambdaType getType() {
        return type;
    }

    public void setType(LambdaType type) {
        this.type = type;
    }

    public ProcessingStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessingStatus status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTypeTagId() {
        return typeTagId;
    }

    public void setTypeTagId(Long typeTagId) {
        this.typeTagId = typeTagId;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Instant completedAt) {
        this.completedAt = completedAt;
    }

    public Instant getKilledAt() {
        return killedAt;
    }

    public void setKilledAt(Instant killedAt) {
        this.killedAt = killedAt;
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

    public String getParametersDoc() {
        return parametersDoc;
    }

    public void setParametersDoc(String parametersDoc) {
        this.parametersDoc = parametersDoc;
    }

    public String getResultsDoc() {
        return resultsDoc;
    }

    public void setResultsDoc(String resultsDoc) {
        this.resultsDoc = resultsDoc;
    }

    public TriggeredBy getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(TriggeredBy triggeredBy) {
        this.triggeredBy = triggeredBy;
    }
}
