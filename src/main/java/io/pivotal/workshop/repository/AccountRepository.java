package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
}
