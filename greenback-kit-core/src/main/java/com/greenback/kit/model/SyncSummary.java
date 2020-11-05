package com.greenback.kit.model;

import static java.util.Optional.ofNullable;

public class SyncSummary {
    
    private SyncDocumentTotals transactions;
    private SyncDocumentTotals messages;

    public SyncDocumentTotals getTransactions() {
        return transactions;
    }

    public void setTransactions(SyncDocumentTotals transactions) {
        this.transactions = transactions;
    }

    public SyncDocumentTotals getMessages() {
        return messages;
    }

    public void setMessages(SyncDocumentTotals messages) {
        this.messages = messages;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        if (transactions != null) {
//            sb.append("transactions={").append(transactions).append("}");
//        }
//        if (messages != null) {
//            if (sb.length() > 0) {
//                sb.append(", ");
//            }
//            sb.append("messages={").append(messages).append("}");
//        }
//        if (sb.length() == 0) {
//            sb.append("<none>");
//        }
//        return sb.toString();
//    }

    // helpers
    
    public boolean hasWarnings() {
        return this.computeWarningCount() > 0;
    }
    
    public boolean hasErrors() {
        return this.computeErrorCount() > 0;
    }
    
    public int computeWarningCount() {
        return ofNullable(this.transactions).map(v -> v.getWarnings()).orElse(0)
            + ofNullable(this.messages).map(v -> v.getWarnings()).orElse(0);
    }
    
    public int computeErrorCount() {
        return ofNullable(this.transactions).map(v -> v.getErrors()).orElse(0)
            + ofNullable(this.messages).map(v -> v.getErrors()).orElse(0);
    }
    
}