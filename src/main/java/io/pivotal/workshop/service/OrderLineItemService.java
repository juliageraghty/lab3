package io.pivotal.workshop.service;


import io.pivotal.workshop.domain.OrderLineItem;
import io.pivotal.workshop.repository.OrderLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderLineItemService {
    @Autowired
    OrderLineItemRepository orderLineItemRepository;

    public OrderLineItemService(OrderLineItemRepository orderLineItemRepository) {
        super();
        this.orderLineItemRepository = orderLineItemRepository;
    }

    public OrderLineItem save(OrderLineItem orderLineItem) {
        OrderLineItem orderLineItemSaved = orderLineItemRepository.save(orderLineItem);
        return orderLineItemSaved;
    }

    public Optional<OrderLineItem> getOrderLineItem(Long orderLineItemId) {
        return orderLineItemRepository.findById(orderLineItemId);
    }

    public void deleteOrderLineItem(Long orderLineItemId) {
        orderLineItemRepository.deleteById(orderLineItemId);
    }
}
