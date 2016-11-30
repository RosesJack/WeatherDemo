package com.example.administrator.weatherdemo.module.bean;

/**
 * auther：wzy
 * date：2016/12/1 01 :15
 * desc:
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;


@Generated("org.jsonschema2pojo")
public class Now {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("temperature")
    @Expose
    private String temperature;

    /**
     * No args constructor for use in serialization
     */
    public Now() {
    }

    /**
     * @param text
     * @param code
     * @param temperature
     */
    public Now(String text, String code, String temperature) {
        this.text = text;
        this.code = code;
        this.temperature = temperature;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @param temperature The temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Now{" +
                "text='" + text + '\'' +
                ", code='" + code + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
