package com.sergkobiakov.dao;

import com.sergkobiakov.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigDecimal;
import java.util.Optional;

@NoRepositoryBean
public interface AccountRepository extends JpaRepository<Account, String > {

    Optional<Account> updateAccountState(String accountId, BigDecimal value);

}
