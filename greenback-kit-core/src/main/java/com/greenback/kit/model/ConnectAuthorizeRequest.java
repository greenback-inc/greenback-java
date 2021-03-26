package com.greenback.kit.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ConnectAuthorizeRequest {
 
    private Map<String,String> parameters;
    private String completeUrl;

    public Map<String, String> getParameters() {
        return parameters;
    }

    public ConnectAuthorizeRequest setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public String getCompleteUrl() {
        return completeUrl;
    }

    public ConnectAuthorizeRequest setCompleteUrl(String completeUrl) {
        this.completeUrl = completeUrl;
        return this;
    }
    
    // helpers
    
    public ConnectAuthorizeRequest addParameter(String name, String value) {
        Objects.requireNonNull(name, "name was null");
        
        if (this.parameters == null) {
            this.parameters = new LinkedHashMap<>();
        }
        
        return this;
    }
    
}