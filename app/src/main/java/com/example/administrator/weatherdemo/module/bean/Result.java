package com.example.administrator.weatherdemo.module.bean;

/**
 * auther：wzy
 * date：2016/12/1 01 :16
 * desc:
 */

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("now")
    @Expose
    private Now now;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;

    /**
     * No args constructor for use in serialization
     */
    public Result() {
    }

    /**
     * @param now
     * @param location
     * @param lastUpdate
     */
    public Result(Location location, Now now, String lastUpdate) {
        this.location = location;
        this.now = now;
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return The now
     */
    public Now getNow() {
        return now;
    }

    /**
     * @param now The now
     */
    public void setNow(Now now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "Result{" +
                "location=" + location +
                ", now=" + now +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}


