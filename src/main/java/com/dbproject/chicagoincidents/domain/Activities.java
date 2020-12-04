package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="has_Activities", schema = "public")
public class Activities {
    @Id
    private long id;

    @Nullable
    @Column(name= "current_activity")
    String currentactivity;

    @Nullable
    @Column(name = "most_recent_action")
    String mostrecentaction;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Activities() {}

    public Activities(String currentactivity, String mostrecentaction) {
        this.currentactivity = currentactivity;
        this.mostrecentaction = mostrecentaction;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getCurrentactivity() {
        return currentactivity;
    }

    public void setCurrentactivity(String currentactivity) {
        this.currentactivity = currentactivity;
    }

    public String getMostrecentaction() {
        return mostrecentaction;
    }

    public void setMostrecentaction(String mostrecentaction) {
        this.mostrecentaction = mostrecentaction;
    }
}
