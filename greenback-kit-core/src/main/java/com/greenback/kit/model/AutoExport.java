package com.greenback.kit.model;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AutoExport extends GreenbackObject{
    private Long userId;
    private String accountingAccountId;
    private AutoExportRequest request;
    private AutoExportFrequency autoExportFrequency;
    private AutoExportState autoExportState;
    private Boolean emailNotification;
    private Instant createdAt;
    private Instant updatedAt;

    // from expands
    private Account accountingAccount;
    private List<AutoExportAccount> autoExportAccounts = new ArrayList<>();
    private Lambda lastLambda;
    private Paginated<Lambda> allLambdaCompleted = new Paginated<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountingAccountId() {
        return accountingAccountId;
    }

    public void setAccountingAccountId(String accountingAccountId) {
        this.accountingAccountId = accountingAccountId;
    }

    public AutoExportRequest getRequest() {
        return request;
    }

    public void setRequest(AutoExportRequest request) {
        this.request = request;
    }

    public AutoExportFrequency getAutoExportFrequency() {
        return autoExportFrequency;
    }

    public void setAutoExportFrequency(AutoExportFrequency autoExportFrequency) {
        this.autoExportFrequency = autoExportFrequency;
    }

    public AutoExportState getAutoExportState() {
        return autoExportState;
    }

    public void setAutoExportState(AutoExportState autoExportState) {
        this.autoExportState = autoExportState;
    }

    public Boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Boolean emailNotification) {
        this.emailNotification = emailNotification;
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

    public Paginated<Lambda> getAllLambdaCompleted() {
        return allLambdaCompleted;
    }

    public void setAllLambdaCompleted(Paginated<Lambda> allLambdaCompleted) {
        this.allLambdaCompleted = allLambdaCompleted;
    }

    public Integer getConsecutiveErrors() {
        int errors = 0;
        // these should always already be sorted by descending date, so we start at the beginning of the array and work our way backwards
        if (!Objects.isNull(this.allLambdaCompleted)
                && !Objects.isNull(this.allLambdaCompleted.getValues())
                && this.allLambdaCompleted.getValues().size() > 0) {
            for (Lambda l : this.allLambdaCompleted) {
                if (l.getStatus() == ProcessingStatus.SUCCESS) {
                    return errors;
                }

                errors++;
            }
        }

        // if we don't have the lambda data, we can't make any assumptions about consecutive errors
        return null;
    }

    public List<AutoExportAccount> getAutoExportAccounts() {
        return autoExportAccounts;
    }

    public void setAutoExportAccounts(List<AutoExportAccount> autoExportAccounts) {
        this.autoExportAccounts = autoExportAccounts;
    }

    public Account getAccountingAccount() {
        return accountingAccount;
    }

    public void setAccountingAccount(Account accountingAccount) {
        this.accountingAccount = accountingAccount;
    }

    public Lambda getLastLambda() {
        return lastLambda;
    }

    public void setLastLambda(Lambda lastLambda) {
        this.lastLambda = lastLambda;
    }

    public boolean isLastLambdaPending() {
        if (Objects.isNull(this.lastLambda)) {
            return false;
        }

        if (Objects.isNull(this.lastLambda.getCompletedAt())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "AutoExport{" +
            "userId=" + userId +
            ", accountingAccountId=" + accountingAccountId +
            ", request_doc='" + request + '\'' +
            ", frequency=" + autoExportFrequency +
            ", state=" + autoExportState +
            ", email_notification=" + emailNotification +
            ", autoExportAccounts=" + autoExportAccounts +
            ", id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}