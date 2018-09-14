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

    String query5 = "SELECT DISTINCT s.id, s.shipped_date AS shippedDate, s.delivery_date AS deliveryDate, p.quantity, m.name " +
            "FROM amazonTable.shipment_table s, amazonTable.shipment_table_order_line_items o, amazonTable.order_line_item_table p, amazonTable.product_table m " +
            "WHERE account_id =:account_id AND o.order_line_items_id=p.id AND p.product_id=m.id ORDER BY s.delivery_date DESC";

    @Query(value=query5, nativeQuery = true)
    List<ShipmentDetails> queryShipmentsByAccount(@Param("account_id") Long id);
}
