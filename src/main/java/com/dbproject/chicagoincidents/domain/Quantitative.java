package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="has_quantitative", schema = "public")
public class Quantitative {
    @Id
    @Column(name="quantitative_id")
    private Long quantitativeid;

    @Column(name="quantity_type")
    String quantitytype;
    @Nullable
    Double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Quantitative() {}

    public Quantitative(String quantitytype, Double quantity) {
        this.quantitytype = quantitytype;
        this.quantity = quantity;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Long getQuantitativeid() {
        return quantitativeid;
    }

    public void setQuantitativeid(Long quantitativeid) {
        this.quantitativeid = quantitativeid;
    }

    public String getQuantitytype() {
        return quantitytype;
    }

    public void setQuantitytype(String quantitytype) {

        this.quantitytype = quantitytype;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {

        this.quantity = quantity;
    }
}
