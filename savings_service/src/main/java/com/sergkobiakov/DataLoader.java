package com.sergkobiakov;

import com.sergkobiakov.dao.AccountRepository;
import com.sergkobiakov.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;


/**
 * Loads test data for services: A, B
 */
@Component
public class DataLoader implements ApplicationRunner {
    private final AccountRepository repository;

    private final String accountId;

    @Autowired
    public DataLoader(AccountRepository repository, @Value("${custom.account.id}") String accountId) {
        this.repository = repository;
        this.accountId = accountId;
    }

    @Override
    public void run(ApplicationArguments args) {
        Account account = new Account(accountId, BigDecimal.valueOf(new Random().nextDouble()));
        repository.save(account);
    }
}