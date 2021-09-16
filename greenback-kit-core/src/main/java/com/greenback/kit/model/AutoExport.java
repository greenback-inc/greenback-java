package com.greenback.kit.model;

import java.util.List;
import java.util.Objects;

public class AutoExport extends GreenbackObject{
    private String userId;
    private String accountingAccountId;
    private AutoExportRequest parameters;
    private AutoExportFrequency frequency;
    private AutoExportState state;

    // from expands
    private Account accountingAccount;
    private List<Account> accounts;
    private AutoExportRun lastRun;
    private List<AutoExportRun> runs;

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

    public AutoExportRequest getParameters() {
        return parameters;
    }

    public void setParameters(AutoExportRequest parameters) {
        this.parameters = parameters;
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

    public AutoExportRun getLastRun() {
        return lastRun;
    }

    public void setLastRun(AutoExportRun lastRun) {
        this.lastRun = lastRun;
    }

    public List<AutoExportRun> getRuns() {
        return runs;
    }

    public void setAllCompletedRuns(List<AutoExportRun> runs) {
        this.runs = runs;
    }

    public Integer getConsecutiveErrors() {
        int errors = 0;
        // these should always already be sorted by descending date, so we start at the beginning of the array and work our way backwards
        if (!Objects.isNull(this.runs)
                && !Objects.isNull(this.runs)
                && this.runs.size() > 0) {
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
            ", parameters=" + parameters +
            ", frequency=" + frequency +
            ", state=" + state +
            ", accountingAccount=" + accountingAccount +
            ", accounts=" + accounts +
            ", lastRun=" + lastRun +
            ", allCompletedRuns=" + runs +
            '}';
    }
}