package com.greenback.kit.model;

import java.time.Instant;

public class AutoExportRun extends GreenbackObject{
    private String referenceId;
    private AutoExportRunType type;
    private ProcessingStatus status;
    private String userId;
    private Long typeTagId;
    private String lockedBy;
    private String hostname;
    private Instant killedAt;
    private Instant completedAt;
    private Double progress;
    private String message;
    private AutoExportRequest parameters;
    private String resultsDoc;
    private TriggeredBy triggeredBy;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public AutoExportRunType getType() {
        return type;
    }

    public void setType(AutoExportRunType type) {
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

    public AutoExportRequest getParameters() {
        return parameters;
    }

    public void setParameters(AutoExportRequest parameters) {
        this.parameters = parameters;
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

    @Override
    public String toString() {
        return "AutoExportRun{" +
            ", id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", referenceId='" + referenceId + '\'' +
            ", type=" + type +
            ", status=" + status +
            ", userId='" + userId + '\'' +
            ", typeTagId=" + typeTagId +
            ", lockedBy='" + lockedBy + '\'' +
            ", hostname='" + hostname + '\'' +
            ", killedAt=" + killedAt +
            ", completedAt=" + completedAt +
            ", progress=" + progress +
            ", message='" + message + '\'' +
            ", parameters='" + parameters + '\'' +
            ", resultsDoc='" + resultsDoc + '\'' +
            ", triggeredBy=" + triggeredBy +
            '}';
    }
}
