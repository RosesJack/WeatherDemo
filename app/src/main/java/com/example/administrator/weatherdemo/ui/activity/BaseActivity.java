package com.example.administrator.weatherdemo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.weatherdemo.App;
import com.example.administrator.weatherdemo.component.DaggerMainActivityComponent;

import java.util.List;

import javax.inject.Inject;

/**
 * auther：wzy
 * date：2016/11/30 23 :57
 * desc:
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    List<Activity> mActivities;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainActivityComponent.builder()
                .activityListComponent(App.getActivityListComponent())
                .build()
                .inject(this);
        mActivities.add(this);
        onActivituCreate(savedInstanceState);
    }

    public abstract void onActivituCreate(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivities.remove(this);
    }
}
