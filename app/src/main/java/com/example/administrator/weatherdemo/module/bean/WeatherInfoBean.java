package com.example.administrator.weatherdemo.module.bean;


import java.io.Serializable;
import java.util.List;


/**
 * auther：wzy
 * date：2016/12/1 01 :13
 * desc:
 */

public class WeatherInfoBean implements Serializable {

    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "WeatherInfoBean{" +
                "results=" + results +
                '}';
    }
}
