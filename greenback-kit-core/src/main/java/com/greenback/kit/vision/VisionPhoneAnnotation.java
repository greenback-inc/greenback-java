package com.greenback.kit.vision;

public class VisionPhoneAnnotation extends VisionAnnotation {
    
    private String e164;
    private String countryCode;
    
    @Override
    public String getType() {
        return "phone";
    }
    
    public String getE164() {
        return e164;
    }

    public void setE164(String e164) {
        this.e164 = e164;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}