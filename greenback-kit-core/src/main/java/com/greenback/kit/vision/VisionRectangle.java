package com.greenback.kit.vision;

import java.util.Objects;

public class VisionRectangle {
 
    private Float x;
    private Float y;
    private Float w;
    private Float h;
    private String description;

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getW() {
        return w;
    }

    public void setW(Float w) {
        this.w = w;
    }

    public Float getH() {
        return h;
    }

    public void setH(Float h) {
        this.h = h;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        if (this.x == null && this.y == null && this.w == null && this.h == null) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(this.x != null ? this.x : "");
        sb.append(",");
        sb.append(this.y != null ? this.y : "");
        sb.append(" ");
        sb.append(this.w != null ? this.w : "");
        sb.append("x");
        sb.append(this.h != null ? this.h : "");
        
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.x);
        hash = 67 * hash + Objects.hashCode(this.y);
        hash = 67 * hash + Objects.hashCode(this.w);
        hash = 67 * hash + Objects.hashCode(this.h);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VisionRectangle other = (VisionRectangle) obj;
        if (!Objects.equals(this.x, other.x)) {
            return false;
        }
        if (!Objects.equals(this.y, other.y)) {
            return false;
        }
        if (!Objects.equals(this.w, other.w)) {
            return false;
        }
        if (!Objects.equals(this.h, other.h)) {
            return false;
        }
        return true;
    }
    
}