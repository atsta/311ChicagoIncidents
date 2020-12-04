package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="vehicle", schema = "public")
public class Vehicle {
    @Id
    private Long id;

    @Nullable
    @Column(name = "license_plate")
    String licenseplate;
    @Nullable
    String model;
    @Nullable
    String color;
    @Nullable
    @Column(name = "days_abandoned")
    Double daysabandoned;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public Vehicle() {}

    public Vehicle(String licenseplate, String model, String color, Double daysabandoned) {
        this.licenseplate = licenseplate;
        this.model = model;
        this.color = color;
        this.daysabandoned = daysabandoned;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Double getDaysabandoned() {
        return daysabandoned;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDaysabandoned(Double daysabandoned) {
        this.daysabandoned = daysabandoned;
    }
}
