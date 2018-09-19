package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Order;
import io.pivotal.workshop.domain.OrderJSON;
import io.pivotal.workshop.domain.OrdersOverview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    String query = "SELECT DISTINCT o.order_number AS orderNumber, o.order_date AS orderDate, o.total_price AS totalPrice, " +
            "a.street, a.apartment, a.city, a.state, a.zip, a.country AS country, c.name " +
            "FROM amazonTable.order_table o, amazonTable.order_table_order_line_items p, amazonTable.address_table a, amazonTable.order_line_item_table b, amazonTable.product_table c " +
            "WHERE o.account_id=:account_id AND o.shipping_address_id=a.id AND p.order_line_items_id=b.id AND b.product_id=c.id ORDER BY o.order_date DESC";

    @Query("SELECT NEW io.pivotal.workshop.domain.OrdersOverview(o.orderNumber, o.orderDate, o.totalPrice) " +
            "FROM Order o WHERE o.account.id=:account_id ORDER BY o.orderDate DESC")
    List<OrdersOverview> queryAllOrdersByAccount(@Param("account_id") Long id);

    @Query("SELECT NEW io.pivotal.workshop.domain.OrderJSON(o.orderNumber, o.orderDate, o.totalPrice, o.address) " +
            "from Order o WHERE o.account.id=:order_id ORDER BY o.orderDate DESC")
    List<OrderJSON> queryOrderDetails(@Param("order_id") Long id);




}