package com.greenback.kit.model;

import java.util.Map;

public class Account extends GreenbackObject {
 
    private String userId;
    private String connectId;
    private AccountType type;
    private AccountState state;
    private AccountConnectionState connectionState;
    private Integer consecutiveErrors;
    private String defaultName;
    private String overlayName;
    
    // expandable
    private Connect connect;
    private Map<String,Sync> syncs;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }
    
    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
    
    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getOverlayName() {
        return overlayName;
    }

    public void setOverlayName(String overlayName) {
        this.overlayName = overlayName;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public AccountConnectionState getConnectionState() {
        return connectionState;
    }

    public void setConnectionState(AccountConnectionState connectionState) {
        this.connectionState = connectionState;
    }

    public Integer getConsecutiveErrors() {
        return consecutiveErrors;
    }

    public void setConsecutiveErrors(Integer consecutiveErrors) {
        this.consecutiveErrors = consecutiveErrors;
    }

    // helpers
    
//    public String getName() {
//        return maybe(this.overlayName).orElse(this.defaultName);
//    }
//    
//    public GBSync getPendingSync() {
//        return maybe(this.syncs)
//            .map(v -> v.get("pending"))
//            .orElse(null);
//    }
//    
//    public GBSync getLastSync() {
//        return maybe(this.syncs)
//            .map(v -> v.get("last"))
//            .orElse(null);
//    }
//    
//    public GBSync getOkSync() {
//        return maybe(this.syncs)
//            .map(v -> v.get("ok"))
//            .orElse(null);
//    }
//    
//    public DateTime getOkSyncCreatedAt() {
//        return maybe(this.getOkSync())
//            .map(v -> v.getCreatedAt())
//            .orElse(null);
//    }
//    
//    public DateTime getPendingSyncCreatedAt() {
//        return maybe(this.getPendingSync())
//            .map(v -> v.getCreatedAt())
//            .orElse(null);
//    }
//    
//    public DateTime getLastSyncCreatedAt() {
//        return maybe(this.getLastSync())
//            .map(v -> v.getCreatedAt())
//            .orElse(null);
//    }
    
    // expandable

    public Connect getConnect() {
        return connect;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }
    
    public Map<String,Sync> getSyncs() {
        return syncs;
    }

    public void setSyncs(Map<String,Sync> syncs) {
        this.syncs = syncs;
    }

}