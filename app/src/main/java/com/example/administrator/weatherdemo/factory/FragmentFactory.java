package com.example.administrator.weatherdemo.factory;

import android.support.v4.app.Fragment;

import com.example.administrator.weatherdemo.ui.fragment.HomeFragment;
import com.example.administrator.weatherdemo.ui.fragment.OtherFragment;
import com.example.administrator.weatherdemo.ui.fragment.SettingFragment;
import com.example.administrator.weatherdemo.ui.fragment.TitleFragment;

/**
 * auther：wzy
 * date：2016/12/2 01 :26
 * desc:
 */

public class FragmentFactory {
    public static Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new TitleFragment();
            case 2:
                return new OtherFragment();
            case 3:
                return new SettingFragment();
        }
        return null;
    }
}
