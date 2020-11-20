package com.dbproject.chicagoincidents.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="has_Activities", schema = "public")
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long activities_id;

    @Nullable
    String current_activity;
    @Nullable
    String most_recent_action;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private Request request;

    public Activities() {}

    public Activities(String current_activity, String most_recent_action) {
        this.current_activity = current_activity;
        this.most_recent_action = most_recent_action;
    }

    public String getCurrent_activity() {
        return current_activity;
    }

    public void setCurrent_activity(String current_activity) {
        this.current_activity = current_activity;
    }

    public String getMost_recent_action() {
        return most_recent_action;
    }

    public void setMost_recent_action(String most_recent_action) {
        this.most_recent_action = most_recent_action;
    }
}
