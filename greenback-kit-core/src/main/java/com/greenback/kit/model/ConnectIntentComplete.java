package com.greenback.kit.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ConnectIntentComplete {

    private Map<String,String> parameters;
    private ConnectIntentCompleteAction action;

    public Map<String, String> getParameters() {
        return parameters;
    }

    public ConnectIntentComplete setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }
    
    public ConnectIntentCompleteAction getAction() {
        return action;
    }

    public ConnectIntentComplete setAction(ConnectIntentCompleteAction action) {
        this.action = action;
        return this;
    }
    
    // helpers
    
    public ConnectIntentComplete addParameter(String name, String value) {
        Objects.requireNonNull(name, "name was null");
        
        if (this.parameters == null) {
            this.parameters = new LinkedHashMap<>();
        }
        
        this.parameters.put(name, value);
        
        return this;
    }
    
}