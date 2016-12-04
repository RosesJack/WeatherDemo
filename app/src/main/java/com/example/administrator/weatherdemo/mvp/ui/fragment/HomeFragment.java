package com.example.administrator.weatherdemo.mvp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.weatherdemo.R;
import com.example.administrator.weatherdemo.module.bean.Result;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;
import com.example.administrator.weatherdemo.mvp.present.HomeFraPresent;


/**
 * auther：wzy
 * date：2016/12/2 01 :29
 * desc:
 */

public class HomeFragment extends BaseFragment implements HomeFraInt {

    private HomeFraPresent mHomeFraPresent = new HomeFraPresent(this);
    private String TAG = this.getClass().getSimpleName();
    private TextView mCity;
    private TextView mTime;
    private TextView mWeather;
    private EditText mMInputCityName;
    private Button mRefresh;

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        mRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: 点击了");
                mHomeFraPresent.refreshFragmentView();
            }
        });
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        mCity = (TextView) view.findViewById(R.id.city);
        mTime = (TextView) view.findViewById(R.id.time);
        mWeather = (TextView) view.findViewById(R.id.weather);
        mMInputCityName = (EditText) view.findViewById(R.id.input_city_name);
        mRefresh = (Button) view.findViewById(R.id.refresh);
        return view;
    }

    @Override
    protected void lazyLoad() {
        mHomeFraPresent.refreshFragmentView();
    }

    @Override
    public void refreshViewWithData(WeatherInfoBean data) {
        if (data == null || data.getResults() == null || data.getResults().size() <= 0) {
            return;
        }
        Result result = data.getResults().get(0);
        mTime.setText(result.getLastUpdate());
        mWeather.setText(result.getNow().getText());
        mCity.setText(result.getLocation().getName());
        Log.i(TAG, "刷新了页面~~ " + data.toString());
    }

    @Override
    public String getCityName() {
        return mMInputCityName.getText().toString().trim();
    }
}
