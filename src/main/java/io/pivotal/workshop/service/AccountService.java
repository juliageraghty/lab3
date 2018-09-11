package io.pivotal.workshop.service;

import io.pivotal.workshop.domain.Account;
import io.pivotal.workshop.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
        Account accountSaved = accountRepository.save(account);
        return accountSaved;
    }

    public Optional<Account> getAccount(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
