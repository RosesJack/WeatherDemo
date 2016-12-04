package com.example.administrator.weatherdemo.mvp.present;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.weatherdemo.App;
import com.example.administrator.weatherdemo.module.bean.WeatherInfoBean;
import com.example.administrator.weatherdemo.mvp.model.HomeFraModel;
import com.example.administrator.weatherdemo.mvp.model.IHomeFraModel;
import com.example.administrator.weatherdemo.mvp.ui.fragment.HomeFraInt;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * auther：wzy
 * date：2016/12/4 02 :43
 * desc:
 */

public class HomeFraPresent {
    private String TAG = this.getClass().getSimpleName();
    private HomeFraInt mHomeFraInt;
    private IHomeFraModel mHomeFraModel;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            mHomeFraInt.refreshViewWithData((WeatherInfoBean) msg.obj);
        }
    };

    public HomeFraPresent(HomeFraInt homeFragmet) {
        this.mHomeFraInt = homeFragmet;
        //回头使用Dagger2注入
        this.mHomeFraModel = new HomeFraModel();
    }

    public void refreshFragmentView() {
        String cityName = mHomeFraInt.getCityName();
        if (TextUtils.isEmpty(cityName)) {
            return;
        }
        mHomeFraModel.getDataFromServer(new Callback<WeatherInfoBean>() {
            @Override
            public void onResponse(Call<WeatherInfoBean> call, Response<WeatherInfoBean> response) {
                WeatherInfoBean data = response.body();
                Log.i(TAG, "onResponse: "+data.toString());
                Message msg = Message.obtain();
                msg.obj = data;
                mHandler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<WeatherInfoBean> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(App.getContext(), "网络出现异常", Toast.LENGTH_SHORT).show();
            }
        }, cityName);
    }

}
