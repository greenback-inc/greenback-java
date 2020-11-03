package com.greenback.kit.model;

import java.util.List;

public class TransactionMatch {
 
    private Double score;
    private Boolean current;
    private List<String> messages;
    private Transaction document;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Transaction getDocument() {
        return document;
    }

    public void setDocument(Transaction document) {
        this.document = document;
    }

}