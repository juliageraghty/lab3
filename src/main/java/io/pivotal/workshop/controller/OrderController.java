package io.pivotal.workshop.controller;


import io.pivotal.workshop.domain.*;
import io.pivotal.workshop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("amazoncommerce/order")
    public Order createOrder(@RequestBody Order order) {
        Order orderSaved = orderService.save(order);
        return orderSaved;
    }

    @PostMapping("amazoncommerce/order/load")
    public Order createOrder() throws ParseException {
        Set<Address> addressSet = new HashSet<>();
        Address address = new Address((long) 2, "St. Louis", "10337", "Chicago", "IL", "60655", "USA");
        addressSet.add(address);

        Account account = new Account((long)3, "Amy", "Geraghty", "ageraghty@aol.com", addressSet);

        String string = "2005-05-05";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(string);

        Product product = new Product((long)2, "iPhone", "Apple Product", "pic", (long)300);
        Set<OrderLineItem> orderLineItems = new HashSet<>();
        Shipment shipment = new Shipment((long)3,account, address, orderLineItems, date, date);
        OrderLineItem iphones = new OrderLineItem((long)3, product, 6, (long)3, (long) (6*3), shipment);
        orderLineItems.add(iphones);
        Order order = new Order((long) 2, account, (long)22, date, address, orderLineItems, (long)10000);
        Order orderSaved = orderService.save(order);
        return orderSaved;
    }

    @GetMapping("amazoncommerce/ordersByAccount/{accountId}")
    public List<Order> queryOrdersByAccount(@PathVariable("accountId") Long accountId) {
        return orderService.queryOrdersByAccount(accountId);
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
