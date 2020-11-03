package com.greenback.kit.vision;

import com.greenback.kit.model.GeoPoint;

public class VisionPlaceAnnotation extends VisionAnnotation {
    
    private String line1;       // e.g. 123 Main St
    private String line2;       // e.g. Suite 200, or something else...
    private String city;        // e.g. Royal Oak
    private String regionCode;  // e.g. MI
    private String postalCode;  // e.g. 48009
    private String countryCode; // e.g. US
    private GeoPoint location;
    
    @Override
    public String getType() {
        return "place";
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
    
}