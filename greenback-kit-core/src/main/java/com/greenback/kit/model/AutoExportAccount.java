package com.greenback.kit.model;

import java.time.Instant;

public class AutoExportAccount {
    private String account_id;
    private Long auto_export_id;
    private Instant created_at;
    private Instant updated_at;

    // from expands
    private Account account;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Long getAuto_export_id() {
        return auto_export_id;
    }

    public void setAuto_export_id(Long auto_export_id) {
        this.auto_export_id = auto_export_id;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
