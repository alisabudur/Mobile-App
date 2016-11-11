package com.example.alisa.myapplication.domain;

import java.util.Date;

/**
 * Created by Alisa on 11/3/2016.
 */

public class Travel {
    private Integer id;
    private String startLocation;
    private String endLocation;
    private Date date;
    private Integer userId;

    public Travel(Integer id, String startLocation, String endLocation, Date date, Integer userId){
        this.id = id;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.date = date;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
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
