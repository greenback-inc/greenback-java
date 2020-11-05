package com.greenback.kit.model;

import java.time.Instant;
import java.util.Map;

public class SyncRequest {

    private Instant from;
    private Instant to;
    private Integer limit;
    private Boolean reuseProfile;
    private Map<String,String> attributes;
    // for previewing what the sync would do
    private Boolean preview;
    
    public Instant getFrom() {
        return from;
    }

    public SyncRequest setFrom(Instant from) {
        this.from = from;
        return this;
    }

    public Instant getTo() {
        return to;
    }

    public SyncRequest setTo(Instant to) {
        this.to = to;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public SyncRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Boolean getReuseProfile() {
        return reuseProfile;
    }

    public SyncRequest setReuseProfile(Boolean reuseProfile) {
        this.reuseProfile = reuseProfile;
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public SyncRequest setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    public Boolean getPreview() {
        return preview;
    }

    public SyncRequest setPreview(Boolean preview) {
        this.preview = preview;
        return this;
    }
    
}