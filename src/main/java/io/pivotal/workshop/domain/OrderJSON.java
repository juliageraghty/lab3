package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.Set;

public class OrderJSON {
    Long orderNumber;
    Date orderDate;
    Long totalPrice;
    Address address;
    Set<OrderLineItem> orderLineItems;

    @JsonCreator
    public OrderJSON(@JsonProperty("orderNumber") Long orderNumber, @JsonProperty("orderDate") Date orderDate,
                     @JsonProperty("totalPrice") Long totalPrice, @JsonProperty("shippingAddress") Address address) {
                     //@JsonProperty("orderLineItems") Set<OrderLineItem> orderLineItems) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.address = address;
        //this.orderLineItems = orderLineItems;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<OrderLineItem> getOrderLineItem() {
        return orderLineItems;
    }

    public void setOrderLineItem(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
}
