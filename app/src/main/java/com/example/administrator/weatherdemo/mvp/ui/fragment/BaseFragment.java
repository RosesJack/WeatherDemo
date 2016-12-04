package com.example.administrator.weatherdemo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * auther：wzy
 * date：2016/12/1 21 :46
 * desc: Fragment基类
 */

public abstract class BaseFragment extends Fragment {
    private View rootView;
    private String TAG = this.getClass().getSimpleName();
    private boolean isCreateView = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //判断为空，为空就去加载布局，onCreateView在界面切换的时候会被多次调用,防止界面跳转回来的时候显示空白
        if (rootView == null) {
            rootView = createView(inflater, container, savedInstanceState);
            initView();
            initListener();
        }
        isCreateView = true;
        return rootView;
    }

    abstract protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initView();

    protected abstract void initListener();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreateView) {
            //Fragment可见
            lazyLoad();
        } else {
            //不可见
        }
    }

    /**
     * 可见的时候处理一些页面数据刷新的操作，用于应付Fragment被缓存时没有办法进行数据的刷新
     */
    protected void lazyLoad() {
        Log.i(TAG, "lazyLoad执行了: ");
    }
}
