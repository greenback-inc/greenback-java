package com.greenback.kit.model;

import java.util.List;

public class FormField {
 
    private String type;
    private String name;
    private String label;
    private String value;
    private Boolean required;
    private List<FormSelectOption> options;

    // helpers
    
//    public String selectedValue() {
//        if (this.type == null) {
//            return null;
//        }
//        switch (this.type.toLowerCase()) {
//            case "hidden":
//                return this.value;
//            case "select":
//                return maybeStream(this.options)
//                    .jvmStream()
//                    .filter(v -> v.getSelected() != null && v.getSelected())
//                    .findFirst()
//                    .map(v -> v.getValue())
//                    .orElse(null);
//            default:
//                throw new RuntimeException("Unsupported field type " + this.type);
//        }
//    }
    
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
    
}