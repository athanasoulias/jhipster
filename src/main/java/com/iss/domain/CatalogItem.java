package com.iss.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * The persistent class for the catalog_items database table.
 *
 */
@Entity
@Table(name = "catalog_items")
public class CatalogItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String name;

    @Column(name = "price_per_unit")
    private BigDecimal pricePerUnit;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private CatalogItemQuantity quantity;

    private String unit;

    //bi-directional many-to-one association to OrderDetail
    @OneToMany(mappedBy = "catalogItem")
    private List<OrderDetail> orderDetails;

    public CatalogItem() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricePerUnit() {
        return this.pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public CatalogItemQuantity getQuantity() {
        return this.quantity;
    }

    public void setQuantity(CatalogItemQuantity quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        getOrderDetails().add(orderDetail);
        orderDetail.setCatalogItem(this);

        return orderDetail;
    }

    public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
        getOrderDetails().remove(orderDetail);
        orderDetail.setCatalogItem(null);

        return orderDetail;
    }
}
