package com.greenback.kit.model;

public class Attachment {
 
    private String relId;
    private String referenceId;
    private String name;
    private String mediaType;
    private Integer size;
    private String md5;
    private AttachmentWhy why;

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttachmentWhy getWhy() {
        return why;
    }

    public void setWhy(AttachmentWhy why) {
        this.why = why;
    }

}