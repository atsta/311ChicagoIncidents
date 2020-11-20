package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="vehicle", schema = "public")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long vehicle_id;

    @Nullable
    String license_plate;
    String model;
    String color;
    @Nullable
    int days_abandoned;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Vehicle() {}

    public Vehicle(String license_plate, String model, String color, int days_abandoned) {
        this.license_plate = license_plate;
        this.model = model;
        this.color = color;
        this.days_abandoned = days_abandoned;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDays_abandoned() {
        return days_abandoned;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDays_abandoned(int days_abandoned) {
        this.days_abandoned = days_abandoned;
    }
}
