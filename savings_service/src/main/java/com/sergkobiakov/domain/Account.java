package com.sergkobiakov.domain;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    public static final int PRECISION = 10;
    public static final int SCALE = 5;

    public Account() {
    }

    public Account(String id, BigDecimal amount) {
        this.amount = amount;
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(precision = PRECISION, scale = SCALE)
    private BigDecimal amount;

    /*
        Used for optimistic locking
     */
    @Version
    private Long version;

    public AccountDto toAccountDto() {
        return new AccountDto(id, amount);
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                ", version=" + version +
                '}';
    }
}