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

        String string = "2018-10-22";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(string);

        Product product = new Product((long)1, "iPad", "Apple Product", "pic", (long)200);
        Set<OrderLineItem> orderLineItems = new HashSet<>();
        Shipment shipment = new Shipment((long)1,account, address, orderLineItems, date, date);
        OrderLineItem ipads = new OrderLineItem((long)1, product, 2, (long)3, (long) (2*3), shipment);
        orderLineItems.add(ipads);
        Order order = new Order((long) 1, account, (long)10, date, address, orderLineItems, (long)123);
        Order orderSaved = orderService.save(order);
        return orderSaved;
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
