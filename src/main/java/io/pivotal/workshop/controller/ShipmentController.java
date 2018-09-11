package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.Product;
import io.pivotal.workshop.domain.Shipment;
import io.pivotal.workshop.service.ProductService;
import io.pivotal.workshop.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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