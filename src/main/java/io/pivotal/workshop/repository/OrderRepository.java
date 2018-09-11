package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    String query = "SELECT o.id, o.account_id, o.order_number, o.order_date, o.shipping_address_id, o.total_price FROM amazonTable.order_table o WHERE o.account_id=:account_id";
    @Query(value = query, nativeQuery = true)
    List<Order> queryOrdersByAccount(@Param("account_id") Long id);
}
