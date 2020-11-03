package com.greenback.kit.vision;

public class VisionEmailAnnotation extends VisionAnnotation {
    
    private String address;     // normalized version
    private String domain;

    @Override
    public String getType() {
        return "email";
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}