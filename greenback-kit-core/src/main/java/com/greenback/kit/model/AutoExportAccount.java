package com.greenback.kit.model;

public class AutoExportAccount extends GreenbackObject {
    private String accountId;
    private Long autoExportId;

    // from expands
    private Account account;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getAutoExportId() {
        return autoExportId;
    }

    public void setAutoExportId(Long autoExportId) {
        this.autoExportId = autoExportId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AutoExportAccount{" +
            "accountId='" + accountId + '\'' +
            ", autoExportId=" + autoExportId +
            ", account=" + account +
            ", id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
