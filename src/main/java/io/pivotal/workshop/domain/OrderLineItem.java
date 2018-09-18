package io.pivotal.workshop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_LINE_ITEM_TABLE")
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    Product product;

    Integer quantity;
    Long price;

    @Column(name= "total_price", nullable = false)
    Long totalPrice;

    @ManyToOne
    @JsonIgnore
    Shipment shipment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTotalPrice() {
        long totalPrice = price * quantity;
        return  totalPrice;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }


    public OrderLineItem(Long id, Product product, Integer quantity, Long price, Long totalPrice, Shipment shipment) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.shipment = shipment;
    }

    OrderLineItem() { super(); }

}
