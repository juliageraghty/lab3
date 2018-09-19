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
    String name;

    @JsonCreator
    public OrderJSON(@JsonProperty("orderNumber") Long orderNumber, @JsonProperty("orderDate") Date orderDate,
                     @JsonProperty("totalPrice") Long totalPrice, @JsonProperty("shippingAddress") Address address) {
                     //@JsonProperty("name") String name) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.address = address;
        //this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
