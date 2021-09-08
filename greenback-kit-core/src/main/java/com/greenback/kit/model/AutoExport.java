package com.greenback.kit.model;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AutoExport {
    private Long id;
    private Long user_id;
    private String accountingAccountId;
    private String request_doc;
    private AutoExportFrequency autoExportFrequency;
    private AutoExportState autoExportState;
    private Boolean email_notification;
    private List<AutoExportAccount> autoExportAccounts = new ArrayList<>();
    private Instant nextExportAt;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant updatedNextExportAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getAccountingAccountId() {
        return accountingAccountId;
    }

    public void setAccountingAccountId(String accountingAccountId) {
        this.accountingAccountId = accountingAccountId;
    }

    public String getRequest_doc() {
        return request_doc;
    }

    public void setRequest_doc(String request_doc) {
        this.request_doc = request_doc;
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

    public Boolean getEmail_notification() {
        return email_notification;
    }

    public void setEmail_notification(Boolean email_notification) {
        this.email_notification = email_notification;
    }

    public List<AutoExportAccount> getAutoExportAccounts() {
        return autoExportAccounts;
    }

    public void setAutoExportAccounts(List<AutoExportAccount> autoExportAccounts) {
        this.autoExportAccounts = autoExportAccounts;
    }

    public Instant getNextExportAt() {
        return nextExportAt;
    }

    public void setNextExportAt(Instant nextExportAt) {
        this.nextExportAt = nextExportAt;
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

    public Instant getUpdatedNextExportAt() {
        return updatedNextExportAt;
    }

    public void setUpdatedNextExportAt(Instant updatedNextExportAt) {
        this.updatedNextExportAt = updatedNextExportAt;
    }

    public String getRequestJson(String type, String triggeredBy) {

        if (Objects.isNull(this.getAutoExportAccounts())) {
            throw new IllegalArgumentException("AutoExport has no associated accounts defined");
        }

        String accountIds = this.getAutoExportAccounts().stream().map(v2 -> v2.getAccount_id())
            .map(v -> "\"" + v + "\"")
            .collect(Collectors.joining(","));

        final String doc = "{\n" +
            "  \"account_ids\" : [ " + accountIds + " ],\n" +
            "  \"query\" : \"\",\n" +
            "  \"types\" : [ ],\n" +
            "  \"max_transacted_at\" : \"" + Instant.now() + "\",\n" +
            "  \"min_transacted_at\" : \"" + this.getCreatedAt().minus(7, ChronoUnit.DAYS) + "\",\n" + // TODO JB: Will probably have to read this in from the auto export object after that is completed, rather than starting at the time the auto export was created
            "  \"user_id\" : \"" + this.getUser_id()+ "\",\n" +
            "  \"accounting_account_id\" : \"" + this.getAccountingAccountId()+ "\"\n" +
            "}";

        // build property lambda request
        final String json = ""
            + "{\n"
            + " \"type\": \"" + type + "\",\n" // TODO JB: Do we need to store the type on the export table in lens or will it always be EXPORT_RUN for auto export?
            + " \"triggered_by\": \"" + triggeredBy + "\",\n"
            + " \"parameters\": " + doc + "\n"
            + "}";

        return json;
    }

    @Override
    public String toString() {
        return "AutoExport{" +
            "userId=" + user_id +
            ", accountingAccountId=" + accountingAccountId +
            ", request_doc='" + request_doc + '\'' +
            ", frequency=" + autoExportFrequency +
            ", state=" + autoExportState +
            ", email_notification=" + email_notification +
            ", autoExportAccounts=" + autoExportAccounts +
            ", nextExportAt=" + nextExportAt +
            ", id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}