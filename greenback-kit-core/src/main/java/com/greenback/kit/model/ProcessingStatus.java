package com.greenback.kit.model;

public enum ProcessingStatus {
 
    PENDING(false),
    PROCESSING(false),
    SUCCESS(true),
    ERROR(true);
    
    private final boolean terminal;
    
    ProcessingStatus(boolean terminal) {
        this.terminal = terminal;
    }

    public boolean isTerminal() {
        return terminal;
    }

}