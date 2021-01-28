package com.greenback.kit.model;

public class UserPrefs extends GreenbackObject {
 
    private TransactionExportMode transactionExportMode;

    public TransactionExportMode getTransactionExportMode() {
        return transactionExportMode;
    }

    public void setTransactionExportMode(TransactionExportMode transactionExportMode) {
        this.transactionExportMode = transactionExportMode;
    }

}