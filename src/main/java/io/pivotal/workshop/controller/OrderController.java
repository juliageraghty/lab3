package io.pivotal.workshop.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.pivotal.workshop.domain.*;
import io.pivotal.workshop.repository.OrderResponse;
import io.pivotal.workshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.*;

@RestController
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("amazoncommerce/order")
    public Order createOrder(@RequestBody Order order) {
        Order orderSaved = orderService.save(order);
        return orderSaved;
    }

    @GetMapping("amazoncommerce/orderDetailsByAccount/{accountId}")
    public List<Order> queryOrderDetailsByAccount(@PathVariable("accountId") Long accountId) {
        return orderService.queryOrderDetailsByAccount(accountId);
    }

    @GetMapping("amazoncommerce/allOrdersByAccount/{accountId}")
    public List<OrderResponse> queryAllOrdersByAccount(@PathVariable("accountId") Long accountId) {
        return orderService.queryAllOrdersByAccount(accountId);
    }

    @GetMapping("amazoncommerce/order/{orderId}")
    public Order get(@PathVariable("orderId") Long orderId) {
        Optional<Order> orderRetrieved = orderService.getOrder(orderId);
        Order order = orderRetrieved.get();
        return order;
    }

    @PutMapping("amazoncommerce/order/{orderId}")
    public Order updateOrder(@RequestBody Order order) {
        Order orderUpdated = orderService.save(order);
        return orderUpdated;
    }

    @DeleteMapping("amazoncommerce/order/{orderId}")
    public ResponseEntity<?> delete(@PathVariable("orderId") long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().body("Order deletion successful");
    }
}
