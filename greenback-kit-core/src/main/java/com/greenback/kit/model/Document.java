package com.greenback.kit.model;

import java.util.Map;
import java.util.Set;

public class Document extends GreenbackObject {
 
    protected String referenceId;
    protected DocumentMeta meta;
    protected Set<DocumentFlag> flags;
    protected Map<String,String> attributes;
    protected String memo;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public DocumentMeta getMeta() {
        return meta;
    }

    public void setMeta(DocumentMeta meta) {
        this.meta = meta;
    }

    public Set<DocumentFlag> getFlags() {
        return flags;
    }

    public void setFlags(Set<DocumentFlag> flags) {
        this.flags = flags;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}