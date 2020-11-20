package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

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
@Table(name="vehicle", schema = "public")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Nullable
    String license_plate;
    String model;
    String color;
    @Nullable
    int days_abandoned;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    private Request request;



}
