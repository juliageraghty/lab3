package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Address;
import io.pivotal.workshop.domain.OrderLineItem;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface OrderDetails {
    Integer getOrderNumber();
    Date getOrderDate();
    Long getTotalPrice();
    String getStreet();
    String getApartment();
    String getCity();
    String getState();
    String getZip();
    String getCountry();
}
