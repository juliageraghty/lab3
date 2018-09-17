package io.pivotal.workshop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SHIPMENT_TABLE")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

    @OneToOne
    @JoinColumn(name = "SHIPPING_ADDRESS_ID", nullable = false)
    private Address shippingAddress;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="ORDER_LINE_ITEMS_ID")
    private Set<OrderLineItem> orderLineItems = new HashSet<>();

    @Temporal(TemporalType.DATE)
    Date shipped_date;

    @Temporal(TemporalType.DATE)
    Date delivery_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return shippingAddress;
    }

    public void setAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<OrderLineItem> getOrderLineItem() {
        return orderLineItems;
    }

    public void setOrderLineItem(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Date getShippedDate() {
        return shipped_date;
    }

    public void setShippedDate(Date shippedDate) {
        this.shipped_date = shippedDate;
    }

    public Date getDeliveryDate() {
        return delivery_date;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.delivery_date = deliveryDate;
    }

    public Shipment(Long id, Account account, Address shippingAddress, Set<OrderLineItem> orderLineItems, Date shipped_date, Date delivery_date) {
        this.id = id;
        this.account = account;
        this.shippingAddress = shippingAddress;
        this.orderLineItems = orderLineItems;
        this.shipped_date = shipped_date;
        this.delivery_date = delivery_date;
    }

    Shipment() { super(); }

    @Override
    public String toString() {
        return "[Shipment: [id:" + id  + ", address:" + shippingAddress.toString() + ", orderLineItems:"
                + orderLineItems.toString() + ", shipped_date:" + shipped_date.toString() + ", delivery_date:"
                + delivery_date.toString() +"]";
    }
}
