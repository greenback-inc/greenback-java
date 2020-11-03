package com.greenback.kit.vision;

import java.util.List;

public class VisionTransactionMatcher {
    
    private List<VisionDateTimeInterval> transactedAts;
    private List<VisionMoney> amounts;

    public List<VisionDateTimeInterval> getTransactedAts() {
        return transactedAts;
    }

    public void setTransactedAts(List<VisionDateTimeInterval> transactedAts) {
        this.transactedAts = transactedAts;
    }

    public List<VisionMoney> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<VisionMoney> amounts) {
        this.amounts = amounts;
    }
    
}