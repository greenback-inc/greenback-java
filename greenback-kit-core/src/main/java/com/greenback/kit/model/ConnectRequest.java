package com.greenback.kit.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ConnectRequest {
 
    private Map<String,String> parameters;
    private String completeUrl;
    private ConnectAction action;

    public Map<String, String> getParameters() {
        return parameters;
    }

    public ConnectRequest setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public String getCompleteUrl() {
        return completeUrl;
    }

    public ConnectRequest setCompleteUrl(String completeUrl) {
        this.completeUrl = completeUrl;
        return this;
    }

    public ConnectAction getAction() {
        return action;
    }

    public ConnectRequest setAction(ConnectAction action) {
        this.action = action;
        return this;
    }
    
    // helpers
    
    public ConnectRequest addParameter(String name, String value) {
        Objects.requireNonNull(name, "name was null");
        
        if (this.parameters == null) {
            this.parameters = new LinkedHashMap<>();
        }
        
        return this;
    }
    
}