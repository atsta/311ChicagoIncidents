package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="has_relative_location", schema = "public")
public class RelativeLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long relative_location_id;

    @Nullable
    String relative_location;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public RelativeLocation() {}

    public RelativeLocation(String relative_location) {
        this.relative_location = relative_location;
    }

    public String getRelative_location() {
        return relative_location;
    }

    public void setRelative_location(String relative_location) {
        this.relative_location = relative_location;
    }
}
