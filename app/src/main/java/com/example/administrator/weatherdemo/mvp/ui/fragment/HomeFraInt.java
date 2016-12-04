package com.example.administrator.weatherdemo.mvp.ui.fragment;


import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;

/**
 * auther：wzy
 * date：2016/12/3 21 :59
 * desc: HomeFragment的ui操作接口
 */

public interface HomeFraInt {
    void refreshViewWithData(WeatherInfoBean data);

    String getCityName();
}
