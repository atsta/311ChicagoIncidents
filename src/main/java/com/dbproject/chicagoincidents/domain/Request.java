package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.persistence.CascadeType;
import java.sql.Timestamp;

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
    @Column(name="creation_date")
    Timestamp creationdate;
    @Column(name="completion_date")
    Timestamp completiondate;

    Double ward;
    @Column(name="police_distinct")
    Integer policedistinct;
    @Column(name="community_area")
    Integer communityarea;

    @Nullable
    @Column(name="historical_wards")
    Integer historicalwards;
    @Nullable
    @Column(name="zip_codes")
    Integer zipcodes;
    @Nullable
    @Column(name="community_areas")
    Integer communityareas;
    @Nullable
    @Column(name="census_tracks")
    Integer censustracks;
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

    public Request(String srn, String type, String status, Timestamp creationdate, Timestamp completiondate, Double ward, Integer policedistinct, Integer communityarea, Integer historicalwards, Integer zipcodes, Integer communityareas, Integer censustracks, Integer wards) {
        this.srn = srn;
        this.type = type;
        this.status = status;
        this.creationdate = creationdate;
        this.completiondate = completiondate;
        this.ward = ward;
        this.policedistinct = policedistinct;
        this.communityarea = communityarea;
        this.historicalwards = historicalwards;
        this.zipcodes = zipcodes;
        this.communityareas = communityareas;
        this.censustracks = censustracks;
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

    public void setSrn() {
        final String Num = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(2);

        for(int i = 0; i < 1; i++) sb.append(Num.charAt(rnd.nextInt(Num.length())));
        sb.append('-');

        StringBuilder sb1 = new StringBuilder(10);
        for(int i = 0; i < 7; i++) sb1.append(Num.charAt(rnd.nextInt(Num.length())));

        srn = sb.toString() + sb1.toString();
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

    public Timestamp getCompletiondate() {
        return completiondate;
    }

    @Transient
    public String getCompletionDateFormatted() {
        return df.format(completiondate);
    }

    public void setCompletiondate(Timestamp completiondate) {
        this.completiondate = completiondate;
    }

    public Timestamp getCreationdate() {
        return creationdate;
    }

    @Transient
    public String getCreationDateFormatted() {
        return df.format(creationdate);
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate= creationdate;
    }

    public Double getWard() {
        return ward;
    }

    public void setWard(Double ward) {
        this.ward = ward;
    }

    public Integer getPolicedistinct() {
        return policedistinct;
    }

    public void setPolicedistinct(Integer policedistinct) {
        this.policedistinct = policedistinct;
    }

    public Integer getCommunityarea() {
        return communityarea;
    }

    public void setCommunityarea(Integer communityarea) {
        this.communityarea = communityarea;
    }

    public Integer getHistoricalwards() {
        return historicalwards;
    }

    public void setHistoricalwards(Integer historicalwards) {
        this.historicalwards = historicalwards;
    }

    public Integer getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(Integer zipcodes) {
        this.zipcodes = zipcodes;
    }

    public Integer getCommunityareas() {
        return communityareas;
    }

    public void setCommunityareas(Integer communityareas) {
        this.communityareas = communityareas;
    }

    public Integer getCensustracks() {
        return censustracks;
    }

    public void setCensustracks(Integer censustracks) {
        this.censustracks = censustracks;
    }

    public Integer getWards() {
        return wards;
    }

    public void setWards(Integer wards) {
        this.wards = wards;
    }
}
