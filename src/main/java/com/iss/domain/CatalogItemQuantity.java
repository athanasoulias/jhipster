package com.iss.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CatalogItemQuantity implements Serializable {

    private static final long serialVersionUID = 5806740764658221566L;

    private Integer total;
    private Details details;

    public CatalogItemQuantity() {}

    public CatalogItemQuantity(Integer total, Details details) {
        this.total = total;
        this.details = details;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public class Details {

        private Integer quantity;
        private BigDecimal weight;

        public Details() {}

        public Details(Integer quantity, BigDecimal weight) {
            this.quantity = quantity;
            this.weight = weight;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getWeight() {
            return weight;
        }

        public void setWeight(BigDecimal weight) {
            this.weight = weight;
        }
    }
}
