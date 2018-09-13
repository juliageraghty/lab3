package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    String query = "SELECT o.id, o.account_id, o.order_number, o.order_date, o.shipping_address_id, o.total_price " +
            "FROM amazonTable.order_table o WHERE o.account_id=:account_id ORDER BY o.order_date DESC";

    String query2 = "SELECT o.order_number AS orderNumber, o.order_date AS orderDate, o.total_price AS totalPrice " +
            "FROM amazonTable.order_table o WHERE o.account_id=:account_id ORDER BY o.order_date DESC";

    @Query(value = query, nativeQuery = true)
    List<Order> queryOrderDetailsByAccount(@Param("account_id") Long id);

    @Query(value=query2, nativeQuery = true)
    List<OrderResponse> queryAllOrdersByAccount(@Param("account_id") Long id);


}

