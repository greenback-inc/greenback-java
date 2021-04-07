package com.greenback.kit.model;

import java.util.Set;

public class Connect extends GreenbackObject {
 
    private String label;
    private ConnectType type;
    private String name;
    private ConnectState state;
    private Set<String> tags;
    private String logoUrl;
    private String contactId;
    private ConnectAuthStrategy authStrategy;
    private AccountState accountState;
    private AccountConnectionState accountConnectionState;

    // expandable
    
    private ConnectCard card;
    
    public ConnectType getType() {
        return type;
    }

    public void setType(ConnectType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ConnectState getState() {
        return state;
    }

    public void setState(ConnectState state) {
        this.state = state;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public ConnectAuthStrategy getAuthStrategy() {
        return authStrategy;
    }

    public void setAuthStrategy(ConnectAuthStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public AccountConnectionState getAccountConnectionState() {
        return accountConnectionState;
    }

    public void setAccountConnectionState(AccountConnectionState accountConnectionState) {
        this.accountConnectionState = accountConnectionState;
    }

    public ConnectCard getCard() {
        return card;
    }

    public void setCard(ConnectCard card) {
        this.card = card;
    }

}