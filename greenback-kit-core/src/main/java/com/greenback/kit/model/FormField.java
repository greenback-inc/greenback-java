package com.greenback.kit.model;

import java.util.List;
import static java.util.Optional.ofNullable;

public class FormField {
 
    private String type;
    private String name;
    private String label;
    private String value;
    private Boolean required;
    private List<FormSelectOption> options;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public List<FormSelectOption> getOptions() {
        return options;
    }

    public void setOptions(List<FormSelectOption> options) {
        this.options = options;
    }
 
    // helpers

    public String computeValue() {
        if (this.type == null) {
            return null;
        }
        switch (this.type.toLowerCase()) {
            case "select":
                if (this.options == null || this.options.isEmpty()) {
                    return null;
                }
                return this.options.stream()
                    .filter(v -> v.getSelected() != null && v.getSelected())
                    .findFirst()
                    .map(v -> v.getValue())
                    .orElse(null);
            default:
                return this.value;
        }
    }
    
}