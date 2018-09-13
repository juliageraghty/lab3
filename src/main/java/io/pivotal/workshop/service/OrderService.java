package io.pivotal.workshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.pivotal.workshop.domain.Order;
import io.pivotal.workshop.repository.OrderRepository;
import io.pivotal.workshop.repository.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class OrderService {
    @Autowired
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

    public List<Order> queryOrderDetailsByAccount(Long accountId) {
        return orderRepository.queryOrderDetailsByAccount(accountId);
    }

    public List<OrderResponse> queryAllOrdersByAccount(Long accountId) {
        return orderRepository.queryAllOrdersByAccount(accountId);
    }


}
