package com.dbproject.chicagoincidents.domain;

import javax.persistence.*;

@Entity
@Table(name="has_specification", schema = "public")
public class Specification {
    @Id
    private long id;

    String specification;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Specification() {}

    public Specification(String specification) {
        this.specification = specification;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
