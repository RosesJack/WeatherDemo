package com.example.administrator.weatherdemo.component;

import com.example.administrator.weatherdemo.annotation.ActivityScope;
import com.example.administrator.weatherdemo.mvp.ui.activity.BaseActivity;

import dagger.Component;

/**
 * auther：wzy
 * date：2016/12/1 00 :10
 * desc:
 */
@ActivityScope
@Component(dependencies = ActivityListComponent.class)
public interface MainActivityComponent {
    void inject(BaseActivity baseActivity);
}
