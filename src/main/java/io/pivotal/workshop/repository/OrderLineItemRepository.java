package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.OrderLineItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineItemRepository extends PagingAndSortingRepository<OrderLineItem, Long> {
}
