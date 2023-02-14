package com.sergkobiakov.dao;

import com.sergkobiakov.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl extends SimpleJpaRepository<Account, String> implements AccountRepository {

    @Autowired
    public AccountRepositoryImpl(EntityManager em) {
        super(Account.class, em);
    }

    @Transactional
    @Override
    public Optional<Account> updateAccountState(String accountId, BigDecimal value) {
        Optional<Account> result = findById(accountId);
        if (result.isPresent()) {
            Account account = result.get();
            BigDecimal newAmount = account.getAmount().add(value);
            account.setAmount(newAmount);
            return Optional.of(account);
        } else {
            return Optional.empty();
        }
    }
}