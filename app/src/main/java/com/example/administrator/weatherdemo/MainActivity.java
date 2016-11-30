package com.example.administrator.weatherdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.weatherdemo.component.DaggerMainActivityComponent;
import com.example.administrator.weatherdemo.ui.activity.BaseActivity;
import com.example.administrator.weatherdemo.ui.activity.NextActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @Inject
    List<Activity> mActivities;
    private TextView mNext;

    @Override
    public void onActivituCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mNext = (TextView) findViewById(R.id.next);
        Log.i(TAG, "App.getActivityListComponent():" + App.getActivityListComponent());
        DaggerMainActivityComponent.builder()
                .activityListComponent(App.getActivityListComponent())
                .build()
                .inject(this);
        Log.i(TAG, "mActivities:" + mActivities);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }
}
