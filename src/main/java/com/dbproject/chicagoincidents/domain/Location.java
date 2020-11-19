package com.dbproject.chicagoincidents.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="location", schema = "public")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    String address;
    int zip_codes;
    double x_coordinate;
    double y_coordinate;
    double latitude;
    double lognitude;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Location() {}

    public Location(String address, int zip_codes, double x_coordinate, double y_coordinate, double latitude, double lognitude) {
        this.address = address;
        this.zip_codes = zip_codes;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.latitude = latitude;
        this. lognitude = lognitude;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLognitude() {
        return lognitude;
    }

    public void setLognitude(double lognitude) {
        this.lognitude= lognitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip_codes() {
        return zip_codes;
    }

    public void setZip_codes(int zip_codes) {
        this.zip_codes = zip_codes;
    }

}
