package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.OrderLineItem;

import java.util.Date;
import java.util.Set;

public interface ShipmentDetails {
    Long getId();
    Date getShippedDate();
    Date getDeliveryDate();
    String getQuantity();
    String getName();
}
