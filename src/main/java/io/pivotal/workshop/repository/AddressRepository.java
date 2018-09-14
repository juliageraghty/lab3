package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

    String query = "SELECT o.id, o.street, o.apartment, o.city, o.state, o.zip, o.country " +
            "FROM amazonTable.address_table o WHERE o.id=:account_id";

    @Query(value = query, nativeQuery = true)
    Address queryAddressByAccount(@Param("account_id") Long id);
}
