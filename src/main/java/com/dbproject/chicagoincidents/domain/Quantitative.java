package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="has_Quantitative", schema = "public")
public class Quantitative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quantitative_id;

    //enum: hole pots filled, carts delivered, premises baited, premises with garbage, premises with rats
    String quantity_type;
    @Nullable
    Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    private Request request;


    public Quantitative() {}

    public Quantitative(String quantity_type, Double quantity) {
        this.quantity_type = quantity_type;
        this.quantity = quantity;
    }

    public long getQuantitative_id() {
        return quantitative_id;
    }

    public void setQuantitative_id(long quantitative_id) {
        this.quantitative_id = quantitative_id;
    }

    public String getQuantity_type() {
        return quantity_type;
    }

    public void setQuantity_type(String quantity_type) {
        this.quantity_type = quantity_type;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
