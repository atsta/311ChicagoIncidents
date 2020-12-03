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
    @Column(name="zip_codes")
    Integer zipcodes;
    @Column(name="x_coordinate")
    Double xcoordinate;
    @Column(name="y_coordinate")
    Double ycoordinate;
    Double latitude;
    Double longitude;


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

    public Location() {}

    public Location(String address, Integer zipcodes, Double xcoordinate, Double ycoordinate, Double latitude, Double longitude) {
        this.address = address;
        this.zipcodes = zipcodes;
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
        this.latitude = latitude;
        this. longitude = longitude;
    }

    public Double getXcoordinate() {
        return xcoordinate;
    }

    public void setXcoordinate(Double xcoordinate) {
        this.xcoordinate = xcoordinate;
    }

    public Double getYcoordinate() {
        return ycoordinate;
    }

    public void setYcoordinate(Double ycoordinate) {
        this.ycoordinate = ycoordinate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude= longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(Integer zipcodes) {
        this.zipcodes = zipcodes;
    }

}
