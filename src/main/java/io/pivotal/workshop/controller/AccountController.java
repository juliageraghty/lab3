package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.Account;
import io.pivotal.workshop.domain.Address;
import io.pivotal.workshop.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("amazoncommerce/account")
    public Account createAccount(@RequestBody Account account) {
        Account accountSaved = accountService.save(account);
        return accountSaved;
    }

    @PostMapping("amazoncommerce/account/load")
    public Account createAccount() {
        Set<Address> adressSet = new HashSet<>();
        Address address = new Address((long) 2, "St. Louis", "10337", "Chicago", "IL", "60655", "USA");
        adressSet.add(address);
        Account account = new Account((long) 3, "Amy", "Geraghty", "ageraghty@aol.com", adressSet);
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
