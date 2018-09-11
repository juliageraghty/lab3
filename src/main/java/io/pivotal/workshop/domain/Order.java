package io.pivotal.workshop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    @JsonIgnore
    Account account;

    @Column(name= "order_number", nullable = false)
    Long orderNumber;

    @Temporal(TemporalType.DATE)
    @Column(name= "order_date", nullable = false)
    Date orderDate;

    @OneToOne
    @JoinColumn(name = "SHIPPING_ADDRESS_ID", nullable = false)
    @JsonIgnore
    private Address shippingAddress;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderLineItem> orderLineItems = new HashSet<>();

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
        return shippingAddress;
    }

    public void setAddress(Address address) {
        this.shippingAddress = shippingAddress;
    }

    public Set<OrderLineItem> getOrderLineItem() {
        return orderLineItems;
    }

    public void setOrderLineItem(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order(Long id, Account account, Long orderNumber, Date orderDate, Address shippingAddress, Set<OrderLineItem> orderLineItems, Long totalPrice) {
        this.id = id;
        this.account = account;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderLineItems = orderLineItems;
        this.totalPrice = totalPrice;
    }

    Order() {super();}
}
