package com.sergkobiakov.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sergkobiakov.utils.AccountStateSerializer;

import java.math.BigDecimal;

public class AccountDto {

    public AccountDto() {
    }

    public AccountDto(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    private String id;

    @JsonProperty
    @JsonSerialize(using = AccountStateSerializer.class)
    private BigDecimal amount;

    public Account toAccount() {
        return new Account(getId(), amount);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}