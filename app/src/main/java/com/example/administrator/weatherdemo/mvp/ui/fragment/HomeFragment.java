package com.example.administrator.weatherdemo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.weatherdemo.App;
import com.example.administrator.weatherdemo.factory.FragmentFactory;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;

import static android.R.attr.data;

/**
 * auther：wzy
 * date：2016/12/2 01 :29
 * desc:
 */

public class HomeFragment extends BaseFragment {

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(container.getContext());
        textView.setText(this.getClass().getSimpleName());
        return textView;
    }
}
