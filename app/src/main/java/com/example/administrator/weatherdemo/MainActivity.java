package com.example.administrator.weatherdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.weatherdemo.component.DaggerMainActivityComponent;
import com.example.administrator.weatherdemo.module.ContainViewPagerAdapter;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;
import com.example.administrator.weatherdemo.module.net.RequestWeatherInterface;
import com.example.administrator.weatherdemo.ui.activity.BaseActivity;
import com.example.administrator.weatherdemo.ui.activity.NextActivity;

import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @Inject
    List<Activity> mActivities;
    private TextView textview2;
    private TextView textview3;
    private TextView textview;
    private TextView textview4;
    private ViewPager vpCcontainer;
    private LinearLayout bottomContainer;

    @Override
    public void onActivituCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        textview2 = (TextView) findViewById(R.id.textview2);
        textview3 = (TextView) findViewById(R.id.textview3);
        textview = (TextView) findViewById(R.id.textview);
        textview4 = (TextView) findViewById(R.id.textview4);
        vpCcontainer = (ViewPager) findViewById(R.id.vp_container);
        bottomContainer = (LinearLayout) findViewById(R.id.bottom_container);

        Log.i(TAG, "App.getActivityListComponent():" + App.getActivityListComponent());
        Log.i(TAG, "mActivities:" + mActivities);

      /*  mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });*/

       /* network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromServer();
                textview.setEnabled(true);
            }
        });*/

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
            }
        });
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
            }
        });
        textview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
            }
        });
        textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
            }
        });
        //用代码主动点击第一个底部按钮
        textview.performClick();
    }

    private void initViewPager(WeatherInfoBean data) {
        vpCcontainer.setAdapter(new ContainViewPagerAdapter(this.getSupportFragmentManager(), data));

    }

    private void changeChildEnable(View v) {
        int childCount = bottomContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            bottomContainer.getChildAt(i).setEnabled(true);
        }
        TextView currentView = (TextView) v;
        currentView.setEnabled(false);
    }


    private void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thinkpage.cn/v3/weather/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /*
  //https://api.thinkpage.cn/v3/weather/now.json?key=zrmqhnpyglbj3nob&location=beijing&language=zh-Hans&unit=c
         */
        /*RequestWeatherInterface requestWeather = retrofit.create(RequestWeatherInterface.class);
        retrofit2.Call<WeatherInfoBean> call = requestWeather.getWeatherInfo("zrmqhnpyglbj3nob", "beijing", "zh-Hans", "c");
        call.enqueue(new Callback<WeatherInfoBean>() {
            @Override
            public void onResponse(retrofit2.Call<WeatherInfoBean> call, Response<WeatherInfoBean> response) {
                WeatherInfoBean body = response.body();
                Log.i(TAG, "相应结果:" + body);
            }

            @Override
            public void onFailure(retrofit2.Call<WeatherInfoBean> call, Throwable t) {

            }
        });*/

    }
}
