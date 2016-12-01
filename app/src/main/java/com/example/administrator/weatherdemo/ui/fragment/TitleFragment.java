package com.example.administrator.weatherdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * auther：wzy
 * date：2016/12/2 01 :29
 * desc:
 */

public class TitleFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(container.getContext());
        textView.setText(this.getClass().getSimpleName());
        return textView;
    }
}
