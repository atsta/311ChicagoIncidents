package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="request", schema = "public")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Transient
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String srn;
    String type;
    String status;
    Date creation_date;
    Date completion_date;

    int ward;
    int police_distinct;
    int community_area;

    @Nullable
    int historical_wards;
    @Nullable
    int zip_codes;
    @Nullable
    int community_areas;
    @Nullable
    int census_tracks;
    @Nullable
    int wards;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "request")
    @Cascade({CascadeType.ALL})
    private Location location;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "request")
    @Cascade({CascadeType.DELETE})
    private Vehicle vehicle;

    public Request() {}

    public long getId() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getSRN() {
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

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public int getPolice_distinct() {
        return police_distinct;
    }

    public void setPolice_distinct(int police_distinct) {
        this.police_distinct = police_distinct;
    }

    public int getCommunity_area() {
        return community_area;
    }

    public void setCommunity_area(int community_area) {
        this.community_area = community_area;
    }

    public int getHistorical_wards() {
        return historical_wards;
    }

    public void setHistorical_wards(int historical_wards) {
        this.historical_wards = historical_wards;
    }

    public int getZip_codes() {
        return zip_codes;
    }

    public void setZip_codes(int zip_codes) {
        this.zip_codes = zip_codes;
    }

    public int getCommunity_areas() {
        return community_areas;
    }

    public void setCommunity_areas(int community_areas) {
        this.community_areas = community_areas;
    }

    public int getCensus_tracks() {
        return census_tracks;
    }

    public void setCensus_tracks(int census_tracks) {
        this.census_tracks = census_tracks;
    }

    public int getWards() {
        return wards;
    }

    public void setWards(int wards) {
        this.wards = wards;
    }
}
