package io.pivotal.workshop.service;

import io.pivotal.workshop.domain.Order;
import io.pivotal.workshop.domain.OrderJSON;
import io.pivotal.workshop.repository.OrderRepository;
import io.pivotal.workshop.repository.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        super();
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        Order orderSaved = orderRepository.save(order);
        return orderSaved;
    }

    public Optional<Order> getOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<OrderResponse> queryAllOrdersByAccount(Long accountId) {
        return orderRepository.queryAllOrdersByAccount(accountId);
    }

    public List<OrderJSON> queryOrderDetails(Long orderId) {
        return orderRepository.queryOrderDetails(orderId);
    }

}
