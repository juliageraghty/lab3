package io.pivotal.workshop.service;

import io.pivotal.workshop.domain.Shipment;
import io.pivotal.workshop.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentService {

    ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        super();
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment save(Shipment shipment) {
        Shipment savedShipment = shipmentRepository.save(shipment);
        return  savedShipment;
    }

    public Optional<Shipment> getShipment(Long shipmentId) {
        return shipmentRepository.findById(shipmentId);
    }

    public void deleteShipment(Long shipmentId) {
        shipmentRepository.deleteById(shipmentId);
    }

}
