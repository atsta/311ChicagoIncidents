package com.dbproject.chicagoincidents.domain;

import javax.persistence.*;

@Entity
@Table(name="has_SSA", schema = "public")
public class HasSSA {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private long id;

    @Column(name = "ssa_value")
    Integer ssavalue;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public void setRequest(Request request) {
        this.request = request;
    }

    public HasSSA() {}

    public HasSSA(Integer ssavalue) {
        this.ssavalue = ssavalue;
    }

    public Integer getSsavalue() {
        return ssavalue;
    }

    public void setSsavalue(Integer ssavalue) {
        this.ssavalue = ssavalue;
    }
}
