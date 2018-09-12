package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Order;
import io.pivotal.workshop.domain.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.sql.PreparedStatement;
import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    String query = "SELECT o.id, o.account_id, o.order_number, o.order_date, o.shipping_address_id, o.total_price FROM amazonTable.order_table o WHERE o.account_id=:account_id";

    String query2 = "SELECT order_number, shipping_address_id, total_price, (SELECT order_line_items_id FROM amazonTable.order_table_order_line_items AS orderLineItems) FROM amazonTable.order_table WHERE account_id = ?1";

    String query3 = "SELECT NEW io.pivotal.workshop.domain.OrderDetails(o.order_number, o.shipping_address_id, o.total_price, " +
            "(SELECT p.order_line_items_id FROM amazonTable.order_table_order_line_items p AS o.order_line_items) " +
            "FROM Order o WHERE o.account_id =:account_id";

    @Query(value = query, nativeQuery = true)
    List<Order> queryOrdersByAccount(@Param("account_id") Long id);

//    @Query(value=query3, nativeQuery = true)
//    Object queryOrderDetailsByAccount(@Param("account_id") Long id);




}
