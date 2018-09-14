package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    String query = "SELECT DISTINCT o.order_number AS orderNumber, o.order_date AS orderDate, o.total_price AS totalPrice, " +
            "a.street AS street, a.apartment AS apartment, a.city AS city, a.state AS state, a.zip AS zip, a.country AS country " +
            "FROM amazonTable.order_table o, amazonTable.order_table_order_line_items p, amazonTable.address_table a " +
            "WHERE o.account_id=:account_id AND o.shipping_address_id=a.id ORDER BY o.order_date DESC";

    String query2 = "SELECT o.order_number AS orderNumber, o.order_date AS orderDate, o.total_price AS totalPrice " +
            "FROM amazonTable.order_table o WHERE o.account_id=:account_id ORDER BY o.order_date DESC";


    @Query(value = query, nativeQuery = true)
    List<OrderDetails> queryOrderDetailsByAccount(@Param("account_id") Long id);

    @Query(value=query2, nativeQuery = true)
    List<OrderResponse> queryAllOrdersByAccount(@Param("account_id") Long id);



}