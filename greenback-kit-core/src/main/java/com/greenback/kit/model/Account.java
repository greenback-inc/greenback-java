package com.greenback.kit.model;

import java.time.Instant;
import java.util.Map;

public class Account {
 
    private String id;
    private String userId;
    private String connectId;
    private String type;
    private String state;
    private String connectionState;
    private Integer consecutiveErrors;
    private String defaultName;
    private String overlayName;
    private Instant createdAt;
    private Instant updatedAt;
    
    // expandable
    
    private Connect connect;
    private Map<String,Sync> syncs;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public Map<String,Sync> getSyncs() {
        return syncs;
    }

    public void setSyncs(Map<String,Sync> syncs) {
        this.syncs = syncs;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConnectionState() {
        return connectionState;
    }

    public void setConnectionState(String connectionState) {
        this.connectionState = connectionState;
    }

    public Integer getConsecutiveErrors() {
        return consecutiveErrors;
    }

    public void setConsecutiveErrors(Integer consecutiveErrors) {
        this.consecutiveErrors = consecutiveErrors;
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

}