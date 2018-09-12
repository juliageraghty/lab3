package io.pivotal.workshop.controller;


import io.pivotal.workshop.domain.*;
import io.pivotal.workshop.service.OrderLineItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class OrderLineItemController {
    OrderLineItemService orderLineItemService;

    public OrderLineItemController(OrderLineItemService orderLineItemService) {
        this.orderLineItemService = orderLineItemService;
    }

    @PostMapping("amazoncommerce/orderLineItem")
    public OrderLineItem createOrderLineItem(@RequestBody OrderLineItem orderLineItem) {
        OrderLineItem orderSaved = orderLineItemService.save(orderLineItem);
        return orderSaved;
    }

    @GetMapping("amazoncommerce/orderLineItem/{orderLineItemId}")
    public OrderLineItem get(@PathVariable("orderLineItemId") Long orderLineItemId) {
        Optional<OrderLineItem> orderLineItemRetrieved = orderLineItemService.getOrderLineItem(orderLineItemId);
        OrderLineItem orderLineItem = orderLineItemRetrieved.get();
        return orderLineItem;
    }

    @PutMapping("amazoncommerce/orderLineItem/{orderLineItemId}")
    public OrderLineItem updateOrderLineItem(@RequestBody OrderLineItem orderLineItem) {
        OrderLineItem orderLineItemUpdated = orderLineItemService.save(orderLineItem);
        return orderLineItemUpdated;
    }

    @DeleteMapping("amazoncommerce/orderLineItem/{orderLineItemId}")
    public ResponseEntity<?> delete(@PathVariable("orderLineItemId") long orderLineItemId) {
        orderLineItemService.deleteOrderLineItem(orderLineItemId);
        return ResponseEntity.ok().body("OrderLineItem deletion successful");
    }}
