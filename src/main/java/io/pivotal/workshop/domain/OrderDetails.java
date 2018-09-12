package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Set;

public class OrderDetails {

    private Integer orderNumber;
    private Date orderDate;

    @JsonCreator
    public OrderDetails(@JsonProperty("order_number") Integer orderNumber, @JsonProperty("order_date") Date orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
