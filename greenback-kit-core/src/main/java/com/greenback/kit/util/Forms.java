package com.greenback.kit.util;

import com.greenback.kit.model.Form;
import com.greenback.kit.model.FormField;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public class Forms {
 
    static public FormField findFieldByName(
            Form form,
            String name) {
        
        if (form == null || form.getFields() == null || form.getFields().isEmpty()) {
            return null;
        }
        
        return form.getFields().stream()
            .filter(v -> v.getName().equals(name))
            .findFirst()
            .orElse(null);
    }
    
    static public Map<String,String> computeParameters(
            Form form) {
        
        final Map<String,String> values = new LinkedHashMap<>();
        
        if (form != null && form.getFields() != null) {
            form.getFields().forEach(f -> {
                values.put(f.getName(), f.computeValue());
            });
        }
        
        return values;
    }
    
    static public boolean isCompleted(
            Form form,
            Map<String,String> values) {
        
        if (form == null || values == null) {
            return false;
        }
        
        for (Map.Entry<String,String> entry : values.entrySet()) {
            final FormField field = findFieldByName(form, entry.getKey());
            
            if (field == null) {
                return false;
            }
            
            // is it required?
            if (field.getRequired() != null && field.getRequired()) {
                if (entry.getValue() == null || entry.getValue().isEmpty() || entry.getValue().trim().isEmpty()) {
                    return false;
                }
            }
        }
        
        return true;
    }
  
    static public List<String> unmappedMessages(
            Form form,
            Map<String,String> values) {

        final List<String> result = new ArrayList<>();
        
        if (form == null || values == null) {
            result.add("Unknown mapping error");
            return result;
        }
        
        for (Map.Entry<String,String> entry : values.entrySet()) {
            final FormField field = findFieldByName(form, entry.getKey());
            
            if (field == null) {
                result.add("'" + entry.getKey() + "'' is missing in form");
                continue;
            }
            
            // is it required?
            if (field.getRequired() != null && field.getRequired()) {
                if (entry.getValue() == null || entry.getValue().isEmpty() || entry.getValue().trim().isEmpty()) {
                    String msg = "'"+ field.getLabel() + "' is missing.";
                    if (field.getHelp() != null) {
                        msg = msg + " " + field.getHelp();
                    }
                    result.add(msg);
                }
            }
        }
        
        return result;
    }
    
}