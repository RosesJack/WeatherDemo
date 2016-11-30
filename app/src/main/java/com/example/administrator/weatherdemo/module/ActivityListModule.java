package com.example.administrator.weatherdemo.module;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * auther：wzy
 * date：2016/12/1 00 :03
 * desc:
 */
@Module
public class ActivityListModule {
    @Provides
    @Singleton
    List<Activity> provideActivityList() {
        return new ArrayList<Activity>();
    }
}
