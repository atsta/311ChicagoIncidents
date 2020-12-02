package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.persistence.CascadeType;


@Entity
@Table(name="request", schema = "public")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Transient
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String srn;
    String type;
    String status;
    Date creation_date;
    Date completion_date;

    Double ward;
    Integer police_distinct;
    Integer community_area;

    @Nullable
    Integer historical_wards;
    @Nullable
    Integer zip_codes;
    @Nullable
    Integer community_areas;
    @Nullable
    Integer census_tracks;
    @Nullable
    Integer wards;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "request")
    private Location location;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "request")
    private Vehicle vehicle;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "request")
    private HasSSA hasSSA;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "request")
    private Activities activities;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "request")
    private RelativeLocation relativeLocation;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "request")
    private Specification specification;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,orphanRemoval = true, mappedBy = "request")
    private Set<Quantitative> quantitative;

    public Request() {}

    public Request(String srn, String type, String status, Date creation_date, Date completion_date, Double ward, Integer police_distinct, Integer community_area, Integer historical_wards, Integer zip_codes, Integer community_areas, Integer census_tracks, Integer wards) {
        this.srn = srn;
        this.type = type;
        this.status = status;
        this.creation_date = creation_date;
        this.completion_date = completion_date;
        this.ward = ward;
        this.police_distinct = police_distinct;
        this.community_area = community_area;
        this.historical_wards = historical_wards;
        this.zip_codes = zip_codes;
        this.community_areas = community_areas;
        this.census_tracks = census_tracks;
        this.wards = wards;
    }

    public long getId() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCompletion_date() {
        return completion_date;
    }

    @Transient
    public String getCompletionDateFormatted() {
        return df.format(completion_date);
    }

    public void setCompletion_date(Date completion_date) {
        this.completion_date = completion_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    @Transient
    public String getCreationDateFormatted() {
        return df.format(creation_date);
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date= creation_date;
    }

    public Double getWard() {
        return ward;
    }

    public void setWard(Double ward) {
        this.ward = ward;
    }

    public Integer getPolice_distinct() {
        return police_distinct;
    }

    public void setPolice_distinct(Integer police_distinct) {
        this.police_distinct = police_distinct;
    }

    public Integer getCommunity_area() {
        return community_area;
    }

    public void setCommunity_area(Integer community_area) {
        this.community_area = community_area;
    }

    public Integer getHistorical_wards() {
        return historical_wards;
    }

    public void setHistorical_wards(Integer historical_wards) {
        this.historical_wards = historical_wards;
    }

    public Integer getZip_codes() {
        return zip_codes;
    }

    public void setZip_codes(Integer zip_codes) {
        this.zip_codes = zip_codes;
    }

    public Integer getCommunity_areas() {
        return community_areas;
    }

    public void setCommunity_areas(Integer community_areas) {
        this.community_areas = community_areas;
    }

    public Integer getCensus_tracks() {
        return census_tracks;
    }

    public void setCensus_tracks(Integer census_tracks) {
        this.census_tracks = census_tracks;
    }

    public Integer getWards() {
        return wards;
    }

    public void setWards(Integer wards) {
        this.wards = wards;
    }
}
