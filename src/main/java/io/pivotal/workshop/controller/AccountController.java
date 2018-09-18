package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.Account;
import io.pivotal.workshop.domain.Address;
import io.pivotal.workshop.domain.Order;
import io.pivotal.workshop.service.AccountService;
import io.pivotal.workshop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("amazoncommerce/account/")
    public Account createAccount(@RequestBody Account account) {
        Account accountSaved = accountService.save(account);
        return accountSaved;
    }

    @GetMapping("amazoncommerce/account/{accountId}")
    public Account get(@PathVariable("accountId") Long accountId) {
        Optional<Account> accountRetrieved = accountService.getAccount(accountId);
        Account account = accountRetrieved.get();
        return account;
    }

    @PutMapping("amazoncommerce/account/{accountId}")
    public Account updateAccount(@RequestBody Account account) {
        Account accountUpdated = accountService.save(account);
        return accountUpdated;
    }

    @DeleteMapping("amazoncommerce/account/{accountId}")
    public ResponseEntity<?> delete(@PathVariable("accountId") long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok().body("Account deletion successful");
    }
}
