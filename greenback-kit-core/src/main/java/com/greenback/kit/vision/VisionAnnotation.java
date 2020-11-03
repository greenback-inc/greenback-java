package com.greenback.kit.vision;

import java.util.List;

public class VisionAnnotation {
 
    private String id;
    private String text;
    private List<VisionRectangle> bounds;
    private List<VisionTextSpan> spans;
    
    public String getType() {
        return "text";
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public List<VisionRectangle> getBounds() {
        return bounds;
    }

    public void setBounds(List<VisionRectangle> bounds) {
        this.bounds = bounds;
    }

    public List<VisionTextSpan> getSpans() {
        return spans;
    }

    public void setSpans(List<VisionTextSpan> spans) {
        this.spans = spans;
    }
    
    @Override
    public String toString() {
        return this.getType() + ": " + this.text;
    }
    
}