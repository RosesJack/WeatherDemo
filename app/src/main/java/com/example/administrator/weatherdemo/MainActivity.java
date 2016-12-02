package com.example.administrator.weatherdemo;

import android.graphics.Color;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.weatherdemo.customView.NoScrollViewPager;
import com.example.administrator.weatherdemo.module.ContainViewPagerAdapter;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;
import com.example.administrator.weatherdemo.module.net.RequestWeatherInterface;
import com.example.administrator.weatherdemo.mvp.present.MainPresentInt;
import com.example.administrator.weatherdemo.mvp.ui.activity.BaseActivity;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity implements MainPresentInt {
    private static final String TAG = "MainActivity";
    private TextView textview2;
    private TextView textview3;
    private TextView textview1;
    private TextView textview4;
    private NoScrollViewPager vpContainer;
    private LinearLayout bottomContainer;

    @Override
    public void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
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
                textview1.setEnabled(true);
            }
        });*/
    }

    @Override
    public void showViewPager() {
        ContainViewPagerAdapter adapter = new ContainViewPagerAdapter(this.getSupportFragmentManager());
        vpContainer.setAdapter(adapter);
    }


    private void changeChildEnable(View v) {
        int childCount = bottomContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = bottomContainer.getChildAt(i);
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                tv.setTextColor(Color.parseColor("#000000"));
            }
            view.setEnabled(true);
        }
        TextView currentView = (TextView) v;
        currentView.setEnabled(false);
        currentView.setTextColor(Color.parseColor("#ffffff"));
    }


    public static void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thinkpage.cn/v3/weather/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /*
  //https://api.thinkpage.cn/v3/weather/now.json?key=zrmqhnpyglbj3nob&location=beijing&language=zh-Hans&unit=c
         */
        RequestWeatherInterface requestWeather = retrofit.create(RequestWeatherInterface.class);
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
        });

    }

    @Override
    protected void initView() {
        textview2 = (TextView) findViewById(R.id.textview2);
        textview3 = (TextView) findViewById(R.id.textview3);
        textview1 = (TextView) findViewById(R.id.textview);
        textview4 = (TextView) findViewById(R.id.textview4);
        vpContainer = (NoScrollViewPager) findViewById(R.id.vp_container);
        bottomContainer = (LinearLayout) findViewById(R.id.bottom_container);
        Log.i(TAG, "App.getActivityListComponent():" + App.getActivityListComponent());
        Log.i(TAG, "mActivities:" + mActivities);
        showViewPager();
    }

    @Override
    protected void initListener() {
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
                switchPager(0);
            }
        });
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
                switchPager(1);
            }
        });
        textview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
                switchPager(2);
            }
        });
        textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeChildEnable(v);
                switchPager(3);
            }
        });
        vpContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                clickWhickPagerButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //用代码主动点击第一个底部按钮
        textview1.performClick();
    }

    /**
     * PagerView滑动时联动导航按钮的状态
     * 如果有需求滑动要被禁用，这个方法就不必用到了，实现则可以通过
     * 重写ViewPager的onTouchEvent()和onInterceptTouchEvent方法 直接返回false 不进行事件拦截也不消费事件
     *
     * @param position
     */
    private void clickWhickPagerButton(int position) {
        switch (position) {
            case 0:
                changeChildEnable(textview1);
                break;
            case 1:
                changeChildEnable(textview2);
                break;
            case 2:
                changeChildEnable(textview3);
                break;
            case 3:
                changeChildEnable(textview4);
                break;
        }
    }

    /**
     * 按钮控制ViewPager切换
     *
     * @param position
     */
    public void switchPager(int position) {
        //切换动画可以选择有或者无
        vpContainer.setCurrentItem(position, false);
    }
}
