package io.pivotal.workshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.Set;

public class ShipmentJSON {

    Account account;
    Date shippedDate;
    Date deliveryDate;
    Set<OrderLineItem> orderLineItems;

    @JsonCreator
    public ShipmentJSON(@JsonProperty("account") Account account, @JsonProperty("shipped_date") Date shippedDate,
                        @JsonProperty("delivery_date") Date deliveryDate) {
                        //@JsonProperty("orderLineItems") Set<OrderLineItem> orderLineItems) {
        this.account=account;
        this.shippedDate=shippedDate;
        this.deliveryDate=deliveryDate;
        //this.orderLineItems=orderLineItems;

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Set<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
}


