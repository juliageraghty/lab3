package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class OrderDetails {

    Long orderNumber;
    Address shippingAddress;
    Long totalPrice;
    Set<OrderLineItem> lineItems;
    //Set<Shipment> shipments;

    @JsonCreator
    public OrderDetails(@JsonProperty("order_number") Long orderNumber, @JsonProperty("shipping_address_id") Address shippingAddress,
                        @JsonProperty("total_price") Long totalPrice, @JsonProperty("order_line_items") Set<OrderLineItem> lineItems) {
                        //@JsonProperty("shipments") Set<Shipment> shipments) {
        this.orderNumber = orderNumber;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.lineItems = lineItems;
        //this.shipments = shipments;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<OrderLineItem> lineItems) {
        this.lineItems = lineItems;
    }

//    public Set<Shipment> getShipments() {
//        return shipments;
//    }
//
//    public void setShipments(Set<Shipment> shipments) {
//        this.shipments = shipments;
//    }
}
