package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.OrderLineItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderLineItemRepository extends PagingAndSortingRepository<OrderLineItem, Long> {
}
