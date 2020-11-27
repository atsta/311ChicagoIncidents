package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="has_Quantitative", schema = "public")
public class Quantitative {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long quantitative_id;

    //enum: hole pots filled, carts delivered, premises baited, premises with garbage, premises with rats
    String quantity_type;
    @Nullable
    Long quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    private Request request;


    public Quantitative() {}

    public Quantitative(String quantity_type, Long quantity) {
        this.quantity_type = quantity_type;
        this.quantity = quantity;
    }

    public String getQuantity_type() {
        return quantity_type;
    }

    public void setQuantity_type(String quantity_type) {
        this.quantity_type = quantity_type;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
