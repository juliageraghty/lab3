package io.pivotal.workshop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDER_TABLE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    Account account;

    @Column(name= "order_number", nullable = false)
    Long orderNumber;

    @Temporal(TemporalType.DATE)
    @Column(name= "order_date", nullable = false)
    Date orderDate;

    @OneToOne
    @JoinColumn(name = "SHIPPING_ADDRESS_ID", nullable = false)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<OrderLineItem> orderLineItems = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Shipment> shipments = new HashSet<>();

    @Column(name= "total_price", nullable = false)
    Long totalPrice;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(Set<Shipment> shipments) {
        this.shipments = shipments;
    }

    public Order(Long id, Account account, Long orderNumber, Date orderDate, Address address, Set<OrderLineItem> orderLineItems, Long totalPrice, Set<Shipment> shipments) {
        this.id = id;
        this.account = account;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.address = address;
        this.orderLineItems = orderLineItems;
        this.totalPrice = totalPrice;
        this.shipments = shipments;
    }

    Order() {super();}

}
