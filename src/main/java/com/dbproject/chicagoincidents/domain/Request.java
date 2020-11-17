package com.dbproject.chicagoincidents.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Transient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name="request", schema = "public")
public class Request {

    @Transient
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    String srn;
    String type;
    String status;
    Date creation_date;
    Date completion_date;

    public int getId() {
        return id;
    }

    public void setID(int id) {
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
}
