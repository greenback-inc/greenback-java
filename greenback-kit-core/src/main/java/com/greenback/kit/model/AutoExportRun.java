package com.greenback.kit.model;

import java.time.Instant;

public class AutoExportRun extends GreenbackObject {
    private String referenceId;
    private ProcessingStatus status;
    private String userId;
    private Long typeTagId;
    private Instant killedAt;
    private Instant completedAt;
    private Double progress;
    private String message;
    private AutoExportParameters parameters;
    private AutoExportResult results;
    private TriggeredBy triggeredBy;

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

    public AutoExportParameters getParameters() {
        return parameters;
    }

    public void setParameters(AutoExportParameters parameters) {
        this.parameters = parameters;
    }

    public AutoExportResult getResults() {
        return results;
    }

    public void setResults(AutoExportResult resultsDoc) {
        this.results = resultsDoc;
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
            ", status=" + status +
            ", userId='" + userId + '\'' +
            ", typeTagId='" + typeTagId + '\'' +
            ", killedAt=" + killedAt +
            ", completedAt=" + completedAt +
            ", progress=" + progress +
            ", message='" + message + '\'' +
            ", parameters='" + parameters + '\'' +
            ", results='" + results + '\'' +
            ", triggeredBy=" + triggeredBy +
            '}';
    }
}
