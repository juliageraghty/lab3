package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.*;
import io.pivotal.workshop.service.ProductService;
import io.pivotal.workshop.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ShipmentController {
    ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("amazoncommerce/shipment")
    public Shipment createShipment(@RequestBody Shipment shipment) {
        Shipment shipmentSaved = shipmentService.save(shipment);
        return shipmentSaved;
    }

    @PostMapping("amazoncommerce/shipment/load")
    public Shipment createProduct() throws ParseException {
        Set<Address> addressSet = new HashSet<>();
        Address address = new Address((long) 2, "St. Louis", "10337", "Chicago", "IL", "60655", "USA");
        addressSet.add(address);

        Account account = new Account((long)3, "Amy", "Geraghty", "ageraghty@aol.com", addressSet);

        String string = "2005-05-05";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(string);

        Product product = new Product((long)1, "iPhone", "Apple Product", "pic", (long)300);

        Set<OrderLineItem> orderLineItems = new HashSet<>();
        Shipment shipment = new Shipment((long)3,account, address, orderLineItems, date, date);
        OrderLineItem iphones = new OrderLineItem((long)2, product, 6, (long)3, (long) (6*3), null);
        orderLineItems.add(iphones);
        shipmentService.save(shipment);
        return shipment;
    }

    @GetMapping("amazoncommerce/shipment/{shipmentId}")
    public Shipment get(@PathVariable("shipmentId") Long shipmentId) {
        Optional<Shipment> shipmentRetrieved = shipmentService.getShipment(shipmentId);
        Shipment shipment = shipmentRetrieved.get();
        return shipment;
    }

    @PutMapping("amazoncommerce/shipment/{shipmentId}")
    public Shipment updateShipment(@RequestBody Shipment shipment) {
        Shipment shipmentUpdated = shipmentService.save(shipment);
        return shipmentUpdated;
    }

    @DeleteMapping("amazoncommerce/shipment/{shipmentId}")
    public ResponseEntity<?> delete(@PathVariable("shipmentId") long shipmentId) {
        shipmentService.deleteShipment(shipmentId);
        return ResponseEntity.ok().body("Shipment deletion successful");
    }
}
