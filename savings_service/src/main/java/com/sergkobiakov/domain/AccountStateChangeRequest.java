package com.sergkobiakov.domain;

import java.math.BigDecimal;

public class AccountStateChangeRequest {

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountStateChangeRequest{" +
                "amount=" + amount +
                '}';
    }
}
