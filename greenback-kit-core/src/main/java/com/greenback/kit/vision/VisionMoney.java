package com.greenback.kit.vision;

import java.util.Objects;

public class VisionMoney {
 
    private Double value;

    public VisionMoney() {
    }

    public VisionMoney(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public VisionMoney setValue(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return Objects.toString(this.value, null);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.value);
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
        final VisionMoney other = (VisionMoney) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

}