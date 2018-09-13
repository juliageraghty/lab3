package io.pivotal.workshop.repository;

import java.sql.Date;

public interface OrderResponse {
    Integer getOrderNumber();
    Date getOrderDate();
    Long getTotalPrice();
}
