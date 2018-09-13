package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long> {

    String query4 = "SELECT s.id, s.account_id, s.shipped_date, s.delivery_date, s.shipping_address_id FROM amazonTable.shipment_table s " +
            "WHERE account_id =:account_id ORDER BY s.delivery_date DESC";

    @Query(value=query4, nativeQuery = true)
    List<Shipment> queryShipmentsByAccount(@Param("account_id") Long id);
}
