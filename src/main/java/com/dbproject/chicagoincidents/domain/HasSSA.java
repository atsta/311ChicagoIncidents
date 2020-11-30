package com.dbproject.chicagoincidents.domain;

import javax.persistence.*;

@Entity
@Table(name="has_SSA", schema = "public")
public class HasSSA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long ssa_id;

    Integer ssa_value;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public HasSSA() {}

    public HasSSA(Integer ssa_value) {
        this.ssa_value = ssa_value;
    }

    public Integer getSsa_value() {
        return ssa_value;
    }

    public void setSsa_value(Integer ssa_value) {
        this.ssa_value = ssa_value;
    }
}
