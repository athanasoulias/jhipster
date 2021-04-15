package com.iss.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the order_details database table.
 *
 */
@Entity
@Table(name = "order_details")
@NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    private BigDecimal weight;

    //bi-directional many-to-one association to CatalogItem
    @ManyToOne
    @JoinColumn(name = "item_id")
    private CatalogItem catalogItem;

    //bi-directional many-to-one association to Order
    @ManyToOne
    private Order order;

    public OrderDetail() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public CatalogItem getCatalogItem() {
        return this.catalogItem;
    }

    public void setCatalogItem(CatalogItem catalogItem) {
        this.catalogItem = catalogItem;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
