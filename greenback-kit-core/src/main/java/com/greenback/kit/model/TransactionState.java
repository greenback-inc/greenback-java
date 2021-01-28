package com.greenback.kit.model;

public enum TransactionState {

    OPEN,
    PERIOD_OPEN,            // legacy open
    UNPAID,
    PARTIALLY_PAID,
    PAID,
    VOIDED;                 // only open/unpaid can be voided, if paid, you end up with refunded
    
}