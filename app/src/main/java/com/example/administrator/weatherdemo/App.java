package com.example.administrator.weatherdemo;

import android.app.Application;
import android.content.Context;

import com.example.administrator.weatherdemo.component.ActivityListComponent;
import com.example.administrator.weatherdemo.component.DaggerActivityListComponent;

import javax.inject.Inject;

/**
 * auther：wzy
 * date：2016/11/30 23 :58
 * desc:
 */

public class App extends Application {
    private static Context mContext;
    private static ActivityListComponent mActivityListComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mActivityListComponent = DaggerActivityListComponent.create();
    }

    public static Context getContext() {
        return mContext;
    }

    public static ActivityListComponent getActivityListComponent() {
        return mActivityListComponent;
    }
}
