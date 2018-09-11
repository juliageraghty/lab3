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

    @PostMapping("amazoncommerce/orderLineItem/load")
    public OrderLineItem createOrderLineItem() throws ParseException {
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
        orderLineItemService.save(ipads);
        return ipads;
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
