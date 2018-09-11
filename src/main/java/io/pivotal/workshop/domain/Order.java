package io.pivotal.workshop.domain;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ORDER_TABLE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Account account;
    @Column(name= "order_number", nullable = false)
    Long orderNumber;
    @Column(name= "order_date", nullable = false)
    @Temporal(TemporalType.DATE)
    Date orderDate;
    Address address;
    @Column(name= "order_line_item", nullable = false)
    OrderLineItem orderLineItem;
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

    public OrderLineItem getOrderLineItem() {
        return orderLineItem;
    }

    public void setOrderLineItem(OrderLineItem orderLineItem) {
        this.orderLineItem = orderLineItem;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
