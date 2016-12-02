package com.example.administrator.weatherdemo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.administrator.weatherdemo.App;

import java.util.HashMap;
import java.util.Map;

/**
 * auther：wzy
 * date：2016/12/2 23 :19
 * desc: 管理所有的Fragment ， fragment的实例只能通过这个类来构造(饿汉式单例)
 * 用于取消Fragment+viewPager模式的缓存
 */

public class FragmentInstanceManager {
    private FragmentInstanceManager() {

    }

    private static Map<String, Fragment> mFragments = new HashMap<>();
    private static FragmentInstanceManager mInstance = new FragmentInstanceManager();

    public static FragmentInstanceManager getInstance() {
        return mInstance;
    }

    public static Fragment getFragmentInstance(Class<? extends Fragment> clazz, Bundle data) {
        String key = clazz.getSimpleName();
        Fragment fragment = mFragments.get(key);
        if (fragment == null) {
            synchronized (FragmentInstanceManager.class) {
                if (fragment == null) {
                    fragment = data == null ? Fragment.instantiate(App.getContext(), clazz.getName())
                            : Fragment.instantiate(App.getContext(), clazz.getName(), data);
                    mFragments.put(key, fragment);
                }
            }
        }
        return fragment;
    }

    public static Fragment getFragmentInstance(Class<? extends Fragment> clazz) {
        return getFragmentInstance(clazz, null);
    }
}
