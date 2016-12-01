package com.example.administrator.weatherdemo.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.weatherdemo.factory.FragmentFactory;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;

/**
 * auther：wzy
 * date：2016/12/2 01 :21
 * desc:
 */

public class ContainViewPagerAdapter extends FragmentPagerAdapter {
    private WeatherInfoBean mData;

    public ContainViewPagerAdapter(FragmentManager fm, WeatherInfoBean data) {
        super(fm);
        this.mData = data;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
