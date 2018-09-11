package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}
