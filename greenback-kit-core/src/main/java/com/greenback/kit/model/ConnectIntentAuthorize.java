package com.greenback.kit.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ConnectIntentAuthorize {
 
    private Map<String,String> parameters;
    private String completeUrl;

    public Map<String, String> getParameters() {
        return parameters;
    }

    public ConnectIntentAuthorize setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public String getCompleteUrl() {
        return completeUrl;
    }

    public ConnectIntentAuthorize setCompleteUrl(String completeUrl) {
        this.completeUrl = completeUrl;
        return this;
    }
    
    // helpers
    
    public ConnectIntentAuthorize addParameter(String name, String value) {
        Objects.requireNonNull(name, "name was null");
        
        if (this.parameters == null) {
            this.parameters = new LinkedHashMap<>();
        }
        
        this.parameters.put(name, value);
        
        return this;
    }
    
}