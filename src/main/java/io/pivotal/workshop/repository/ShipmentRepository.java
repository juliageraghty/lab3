package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Shipment;
import io.pivotal.workshop.domain.ShipmentJSON;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long> {

    String query5 = "SELECT DISTINCT s.id, s.shipped_date AS shippedDate, s.delivery_date AS deliveryDate, p.quantity, m.name, m.description, m.price " +
            "FROM amazonTable.shipment_table s, amazonTable.shipment_table_order_line_items o, amazonTable.order_line_item_table p, amazonTable.product_table m " +
            "WHERE account_id =:account_id AND o.order_line_items_id=p.id AND p.product_id=m.id ORDER BY s.delivery_date DESC";

    @Query("SELECT NEW io.pivotal.workshop.domain.ShipmentJSON(s.account, s.shipped_date, s.delivery_date, o.orderNumber) " +
            "from Shipment s JOIN s.order o WHERE s.account.id=:shipmentId ORDER BY s.shipped_date DESC")
    List<ShipmentJSON> queryShipmentDetails(@Param("shipmentId") Long id);

}
