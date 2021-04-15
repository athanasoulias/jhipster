package com.iss.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the orders database table.
 *
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "delivery_time")
    private Time deliveryTime;

    @Column(name = "delivery_type")
    private String deliveryType;

    @Column(name = "order_timestamp")
    private Timestamp orderTimestamp;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "price_total")
    private BigDecimal priceTotal;

    private String remarks;

    private String status;

    //bi-directional many-to-one association to OrderDetail
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    //bi-directional many-to-one association to Customer
    @ManyToOne
    private Customer customer;

    public Order() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryType() {
        return this.deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Timestamp getOrderTimestamp() {
        return this.orderTimestamp;
    }

    public void setOrderTimestamp(Timestamp orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPriceTotal() {
        return this.priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        getOrderDetails().add(orderDetail);
        orderDetail.setOrder(this);

        return orderDetail;
    }

    public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
        getOrderDetails().remove(orderDetail);
        orderDetail.setOrder(null);

        return orderDetail;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
