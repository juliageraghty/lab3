package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Shipment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long> {
}
