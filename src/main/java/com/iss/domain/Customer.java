package com.iss.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

/**
 * The persistent class for the customers database table.
 *
 */
@Entity
@Table(name = "customers")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private String area;

    private String city;

    private String name;

    @Type(type = "jsonb")
    @Column(name = "telephone_nos", columnDefinition = "jsonb")
    private String[] telephoneNos;

    //bi-directional many-to-one association to Order
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTelephoneNos() {
        return this.telephoneNos;
    }

    public void setTelephoneNos(String[] telephoneNos) {
        this.telephoneNos = telephoneNos;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order addOrder(Order order) {
        getOrders().add(order);
        order.setCustomer(this);

        return order;
    }

    public Order removeOrder(Order order) {
        getOrders().remove(order);
        order.setCustomer(null);

        return order;
    }
}
