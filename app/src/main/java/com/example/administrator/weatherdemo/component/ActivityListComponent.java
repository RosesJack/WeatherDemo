package com.example.administrator.weatherdemo.component;

import android.app.Activity;

import com.example.administrator.weatherdemo.module.ActivityListModule;

import java.util.List;

import javax.inject.Singleton;

import dagger.Component;

/**
 * auther：wzy
 * date：2016/12/1 00 :05
 * desc:
 */
@Singleton
@Component(modules = ActivityListModule.class)
public interface ActivityListComponent {
    List<Activity> getActivityList();
}
