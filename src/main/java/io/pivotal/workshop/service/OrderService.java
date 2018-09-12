package io.pivotal.workshop.service;

import io.pivotal.workshop.domain.Order;
import io.pivotal.workshop.domain.OrderDetails;
import io.pivotal.workshop.repository.OrderRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public List<Order> queryOrdersByAccount(Long accountId) {
        return orderRepository.queryOrdersByAccount(accountId);
    }

//    public Object queryOrderDetailsByAccount(Long accountId) { return orderRepository.queryOrderDetailsByAccount(accountId);}

}
