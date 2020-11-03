package com.greenback.kit.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Form {
 
    private List<FormField> fields;

    public List<FormField> getFields() {
        return fields;
    }

    public void setFields(List<FormField> fields) {
        this.fields = fields;
    }
    
    // helpers
    
    public FormField findField(
            String name) {
        
        if (this.fields == null || this.fields.isEmpty()) {
            return null;
        }
        
        return this.fields.stream()
            .filter(v -> v.getName().equals(name))
            .findFirst()
            .orElse(null);
    }
    
//    public Map<String,String> buildParameters() {
//        Map<String,String> parameters = new LinkedHashMap<>();
//        
//        if (!isEmpty(this.fields)) {
//            fields.forEach(f -> {
//                parameters.put(f.getName(), f.selectedValue());
//            });
//        }
//        
//        return parameters;
//    }
//    
//    public boolean isComplete(
//            Map<String,String> parameters) {
//        
//        if (isEmpty(parameters)) {
//            return false;
//        }
//        
//        for (Map.Entry<String,String> entry : parameters.entrySet()) {
//            final GBFormField field = this.findField(entry.getKey());
//            
//            if (field == null) {
//                return false;
//            }
//            
//            // is it required?
//            if (field.getRequired() != null && field.getRequired()) {
//                if (entry.getValue() == null || entry.getValue().isEmpty() || entry.getValue().trim().isEmpty()) {
//                    return false;
//                }
//            }
//        }
//        
//        return true;
//    }

}