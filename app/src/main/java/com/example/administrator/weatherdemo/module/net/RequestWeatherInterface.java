package com.example.administrator.weatherdemo.module.net;

import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * auther：wzy
 * date：2016/12/1 01 :25
 * desc:
 */

public interface RequestWeatherInterface {
    //https://api.thinkpage.cn/v3/weather/now.json?key=zrmqhnpyglbj3nob&location=beijing&language=zh-Hans&unit=c
    @GET("now.json")
    Call<WeatherInfoBean> getWeatherInfo
    (@Query("key") String key, @Query("location") String location,
     @Query("language") String language, @Query("unit") String unit);

}
