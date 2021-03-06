package com.example.administrator.weatherdemo.mvp.model;

import android.util.Log;

import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;
import com.example.administrator.weatherdemo.module.net.RequestWeatherInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * auther：wzy
 * date：2016/12/3 22 :01
 * desc:
 */

public class HomeFraModel implements IHomeFraModel {
    private String TAG = this.getClass().getSimpleName();

    @Override
    public void getDataFromServer(Callback<WeatherInfoBean> callback, String cityName) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thinkpage.cn/v3/weather/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        /*
             //https://api.thinkpage.cn/v3/weather/now.json?key=zrmqhnpyglbj3nob&location=beijing&language=zh-Hans&unit=c
         */
        RequestWeatherInterface requestWeather = retrofit.create(RequestWeatherInterface.class);
        retrofit2.Call<WeatherInfoBean> call = requestWeather.getWeatherInfo("zrmqhnpyglbj3nob", cityName, "zh-Hans", "c");
        call.enqueue(callback);
    }

}
