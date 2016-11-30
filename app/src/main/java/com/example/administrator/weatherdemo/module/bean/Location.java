package com.example.administrator.weatherdemo.module.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * auther：wzy
 * date：2016/12/1 01 :18
 * desc:
 */
public class Location {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("timezone_offset")
    @Expose
    private String timezoneOffset;

    /**
     * No args constructor for use in serialization
     */
    public Location() {
    }

    /**
     * @param id
     * @param timezone
     * @param name
     * @param path
     * @param timezoneOffset
     * @param country
     */
    public Location(String id, String name, String country, String path, String timezone, String timezoneOffset) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.path = path;
        this.timezone = timezone;
        this.timezoneOffset = timezoneOffset;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * @param timezone The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * @return The timezoneOffset
     */
    public String getTimezoneOffset() {
        return timezoneOffset;
    }

    /**
     * @param timezoneOffset The timezone_offset
     */
    public void setTimezoneOffset(String timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", path='" + path + '\'' +
                ", timezone='" + timezone + '\'' +
                ", timezoneOffset='" + timezoneOffset + '\'' +
                '}';
    }
}
