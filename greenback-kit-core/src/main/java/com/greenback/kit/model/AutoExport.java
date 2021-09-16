package com.greenback.kit.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AutoExport extends GreenbackObject{
    private String userId;
    private String accountingAccountId;
    private AutoExportRequest request;
    private AutoExportFrequency frequency;
    private AutoExportState state;
    private Boolean emailNotification;

    // from expands
    private Account accountingAccount;
    private List<Account> accounts;
    private AutoExportRun lastRun;
    private Paginated<AutoExportRun> runs;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public AutoExportFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(AutoExportFrequency frequency) {
        this.frequency = frequency;
    }

    public AutoExportState getState() {
        return state;
    }

    public void setState(AutoExportState state) {
        this.state = state;
    }

    public Boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public AutoExportRun getLastRun() {
        return lastRun;
    }

    public void setLastRun(AutoExportRun lastRun) {
        this.lastRun = lastRun;
    }

    public Paginated<AutoExportRun> getRuns() {
        return runs;
    }

    public void setAllCompletedRuns(Paginated<AutoExportRun> runs) {
        this.runs = runs;
    }

    public Integer getConsecutiveErrors() {
        int errors = 0;
        // these should always already be sorted by descending date, so we start at the beginning of the array and work our way backwards
        if (!Objects.isNull(this.runs)
                && !Objects.isNull(this.runs.getValues())
                && this.runs.getValues().size() > 0) {
            for (AutoExportRun l : this.runs) {
                if (l.getStatus() == ProcessingStatus.SUCCESS) {
                    return errors;
                }

                errors++;
            }
        }

        // if we don't have the lambda data, we can't make any assumptions about consecutive errors
        return null;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccountingAccount() {
        return accountingAccount;
    }

    public void setAccountingAccount(Account accountingAccount) {
        this.accountingAccount = accountingAccount;
    }

    public boolean isLastRunPending() {
        if (Objects.isNull(this.lastRun)) {
            return false;
        }

        if (Objects.isNull(this.lastRun.getCompletedAt())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "AutoExport{" +
            "id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", userId='" + userId + '\'' +
            ", accountingAccountId='" + accountingAccountId + '\'' +
            ", request=" + request +
            ", frequency=" + frequency +
            ", state=" + state +
            ", emailNotification=" + emailNotification +
            ", accountingAccount=" + accountingAccount +
            ", accounts=" + accounts +
            ", lastRun=" + lastRun +
            ", allCompletedRuns=" + runs +
            '}';
    }
}