package com.greenback.kit.model;

import java.util.List;

public class TransactionExporter {
 
    private String targetId;
    private Form form;
    private List<TransactionMatch> matches;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public List<TransactionMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<TransactionMatch> matches) {
        this.matches = matches;
    }

}