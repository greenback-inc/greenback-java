package com.greenback.kit.model;

public enum TransactionExportDeleteMode {
    
    DEFAULT,                        // must be deleted in accounting before cleared in gb
    IGNORE_ACCOUNTING_FAILURE,      // ignore any failure in accounting delete, then clear in gb
    SKIP_ACCOUNTING                 // skip deleting in accounting, just clear in gb
    
}