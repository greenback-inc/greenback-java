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
            ", lastRun=" + lastRun +
            '}';
    }
}