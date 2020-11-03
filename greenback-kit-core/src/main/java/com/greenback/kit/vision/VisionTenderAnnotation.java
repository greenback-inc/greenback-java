package com.greenback.kit.vision;

public class VisionTenderAnnotation extends VisionAnnotation {
    
    private VisionTenderMethod method;
    private String endsWith;

    @Override
    public String getType() {
        return "tender";
    }
    
    public VisionTenderMethod getMethod() {
        return method;
    }

    public void setMethod(VisionTenderMethod method) {
        this.method = method;
    }

    public String getEndsWith() {
        return endsWith;
    }

    public void setEndsWith(String endsWith) {
        this.endsWith = endsWith;
    }
    
}