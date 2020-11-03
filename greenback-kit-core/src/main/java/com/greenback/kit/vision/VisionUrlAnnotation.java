package com.greenback.kit.vision;

public class VisionUrlAnnotation extends VisionAnnotation {
    
    private String url;     // normalized version
    private String domain;

    @Override
    public String getType() {
        return "url";
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}