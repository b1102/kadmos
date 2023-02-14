package com.sergkobiakov.controller;


import com.sergkobiakov.dao.AccountRepository;
import com.sergkobiakov.domain.Account;
import com.sergkobiakov.domain.AccountDto;
import com.sergkobiakov.domain.AccountStateChangeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/savings")
public class AccountController {

    private final AccountRepository repository;

    @Autowired
    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{accountId}/balance")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("accountId") String accountId) {
        Optional<Account> result = repository.findById(accountId);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get().toAccountDto(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/{accountId}/balance")
    public ResponseEntity<AccountDto> updateAccountById(
            @PathVariable("accountId") String accountId,
            @RequestBody AccountStateChangeRequest request
    ) {
        Optional<Account> result = repository.updateAccountState(accountId, request.getAmount());
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get().toAccountDto(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
