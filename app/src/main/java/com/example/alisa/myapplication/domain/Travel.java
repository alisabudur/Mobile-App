package com.example.alisa.myapplication.domain;

import java.util.Date;

/**
 * Created by Alisa on 11/3/2016.
 */

public class Travel {
    private long id;
    private String startLocation;
    private String endLocation;
    private Date date;
    private Integer userId;

    public Travel() {
    }

    public Travel(String stratLocation, String endLocation) {
        this.startLocation = stratLocation;
        this.endLocation = endLocation;
    }

    public Travel(long id, String startLocation, String endLocation, Date date, Integer userId) {
        this.id = id;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.date = date;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }
}
