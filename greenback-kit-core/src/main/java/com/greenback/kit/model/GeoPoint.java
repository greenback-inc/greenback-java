package com.greenback.kit.model;

import java.util.Objects;

public class GeoPoint {

    private Double lat;
    private Double lon;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
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
        final GeoPoint other = (GeoPoint) obj;
        if (!Objects.equals(this.lat, other.lat)) {
            return false;
        }
        return Objects.equals(this.lon, other.lon);
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 19 * hash + Objects.hashCode(this.lat);
        hash = 19 * hash + Objects.hashCode(this.lon);
        return hash;
    }

    @Override
    public String toString() {
        return lat + "," + lon;
    }
    
}