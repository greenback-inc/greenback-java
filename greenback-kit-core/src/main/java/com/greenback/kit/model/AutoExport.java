package com.greenback.kit.model;

import java.util.List;

public class AutoExport extends GreenbackObject {
    private String userId;
    private String accountingAccountId;
    private AutoExportParameters parameters;
    private AutoExportFrequency frequency;
    private AutoExportState state;
    private List<String> accountIds;

    // from expands
    private Account accountingAccount;
    private List<Account> accounts;
    private ExportRun lastRun;
    private ExportRun pendingRun;

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

    public AutoExportParameters getParameters() {
        return parameters;
    }

    public void setParameters(AutoExportParameters parameters) {
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

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public ExportRun getLastRun() {
        return lastRun;
    }

    public void setLastRun(ExportRun lastRun) {
        this.lastRun = lastRun;
    }

    public ExportRun getPendingRun() {
        return pendingRun;
    }

    public void setPendingRun(ExportRun pendingRun) {
        this.pendingRun = pendingRun;
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
            ", accountIds=" + accountIds +
            ", lastRun=" + lastRun +
            ", pendingRun=" + lastRun +
            '}';
    }
}