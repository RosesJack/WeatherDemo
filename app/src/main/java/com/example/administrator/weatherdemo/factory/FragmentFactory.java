package com.example.administrator.weatherdemo.factory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.administrator.weatherdemo.App;
import com.example.administrator.weatherdemo.MainActivity;
import com.example.administrator.weatherdemo.module.bean.Location;
import com.example.administrator.weatherdemo.module.bean.Now;
import com.example.administrator.weatherdemo.module.bean.Result;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;
import com.example.administrator.weatherdemo.mvp.ui.fragment.FragmentInstanceManager;
import com.example.administrator.weatherdemo.mvp.ui.fragment.HomeFragment;
import com.example.administrator.weatherdemo.mvp.ui.fragment.OtherFragment;
import com.example.administrator.weatherdemo.mvp.ui.fragment.SettingFragment;
import com.example.administrator.weatherdemo.mvp.ui.fragment.TitleFragment;

import java.util.ArrayList;

import static android.R.attr.data;

/**
 * auther：wzy
 * date：2016/12/2 01 :26
 * desc:
 */

public class FragmentFactory {
    public static String BUNDLE_FLAG = "DATA";

    public static Fragment createFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = FragmentInstanceManager.getFragmentInstance(HomeFragment.class);
                return fragment;
            case 1:
                fragment = FragmentInstanceManager.getFragmentInstance(TitleFragment.class);
                return fragment;
            case 2:
                fragment = FragmentInstanceManager.getFragmentInstance(OtherFragment.class);
                return fragment;
            case 3:
                fragment = FragmentInstanceManager.getFragmentInstance(SettingFragment.class);
                return fragment;
        }
        return null;
    }
}
