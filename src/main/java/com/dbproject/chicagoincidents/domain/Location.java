package com.dbproject.chicagoincidents.domain;

import javax.persistence.*;

@Entity
@Table(name="location", schema = "public")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long location_id;

    String address;
    int zip_codes;
    double x_coordinate;
    double y_coordinate;
    double latitude;
    double longitude;


    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Location() {}

    public Location(String address, int zip_codes, double x_coordinate, double y_coordinate, double latitude, double longitude) {
        this.address = address;
        this.zip_codes = zip_codes;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.latitude = latitude;
        this. longitude = longitude;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude= longitude;
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
