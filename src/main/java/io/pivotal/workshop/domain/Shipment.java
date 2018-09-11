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
    private Set<OrderLineItem> orderLineItems = new HashSet<>();

    @Temporal(TemporalType.DATE)
    Date shippedDate;

    @Temporal(TemporalType.DATE)
    Date deliveryDate;

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

    public Shipment(Long id, Account account, Address shippingAddress, Set<OrderLineItem> orderLineItems, Date shippedDate, Date deliveryDate) {
        this.id = id;
        this.account = account;
        this.shippingAddress = shippingAddress;
        this.orderLineItems = orderLineItems;
        this.shippedDate = shippedDate;
        this.deliveryDate = deliveryDate;
    }

    Shipment() { super(); }
}
