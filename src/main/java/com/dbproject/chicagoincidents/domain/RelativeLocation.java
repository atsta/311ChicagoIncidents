package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="has_relative_location", schema = "public")
public class RelativeLocation {
    @Id
    private long id;

    @Column(name = "relative_location")
    String relativelocation;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public RelativeLocation() {}

    public RelativeLocation(String relativelocation) {
        this.relativelocation = relativelocation;
    }

    public String getRelativelocation() {
        return relativelocation;
    }

    public void setRelativelocation(String relativelocation) {
        this.relativelocation = relativelocation;
    }
}
