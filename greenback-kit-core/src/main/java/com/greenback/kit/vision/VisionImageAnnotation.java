package com.greenback.kit.vision;

public class VisionImageAnnotation extends VisionAnnotation {
    
    private String md5;
    private Integer naturalWidth;
    private Integer naturalHeight;

    @Override
    public String getType() {
        return "image";
    }
    
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getNaturalWidth() {
        return naturalWidth;
    }

    public void setNaturalWidth(Integer naturalWidth) {
        this.naturalWidth = naturalWidth;
    }

    public Integer getNaturalHeight() {
        return naturalHeight;
    }

    public void setNaturalHeight(Integer naturalHeight) {
        this.naturalHeight = naturalHeight;
    }

}