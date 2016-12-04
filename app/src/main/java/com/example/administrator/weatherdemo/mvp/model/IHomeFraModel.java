package com.example.administrator.weatherdemo.mvp.model;

import android.util.Log;

import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;
import com.example.administrator.weatherdemo.module.net.RequestWeatherInterface;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * auther：wzy
 * date：2016/12/3 22 :00
 * desc:
 */

public interface IHomeFraModel {
    void getDataFromServer(Callback<WeatherInfoBean> callback, String cityName);
}
