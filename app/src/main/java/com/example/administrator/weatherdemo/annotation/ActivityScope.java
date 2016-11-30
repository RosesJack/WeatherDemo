package com.example.administrator.weatherdemo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * auther：wzy
 * date：2016/12/1 00 :28
 * desc:
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {

}
