package com.example.administrator.weatherdemo.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.example.administrator.weatherdemo.factory.FragmentFactory;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;

import static android.R.attr.data;

/**
 * auther：wzy
 * date：2016/12/2 01 :21
 * desc:
 */

public class ContainViewPagerAdapter extends FragmentPagerAdapter {
    private static int COUNT = 4;
    private String TAG = this.getClass().getSimpleName();

    public ContainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i(TAG, "instantiateItem执行: ");
        return super.instantiateItem(container, position);
    }
}
