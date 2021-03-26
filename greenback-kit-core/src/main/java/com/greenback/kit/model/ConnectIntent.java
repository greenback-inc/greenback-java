package com.greenback.kit.model;

import java.time.Instant;

public class ConnectIntent extends GreenbackObject {
 
    private String token;
    private String connectId;
    private String accountId;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant completedAt;
    private ConnectIntentAction action;
    private String redirectUrl;
    private Form input;
    private ConnectCompleteAction confirm;
    private GreenbackError error;
    
    // expansions

    private Connect connect;
    private Account account;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public Instant getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Instant completedAt) {
        this.completedAt = completedAt;
    }

    public ConnectIntentAction getAction() {
        return action;
    }

    public void setAction(ConnectIntentAction action) {
        this.action = action;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Form getInput() {
        return input;
    }

    public void setInput(Form input) {
        this.input = input;
    }

    public ConnectCompleteAction getConfirm() {
        return confirm;
    }

    public void setConfirm(ConnectCompleteAction confirm) {
        this.confirm = confirm;
    }

    public GreenbackError getError() {
        return error;
    }

    public void setError(GreenbackError error) {
        this.error = error;
    }

    public Connect getConnect() {
        return connect;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}