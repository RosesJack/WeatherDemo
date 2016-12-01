package com.example.administrator.weatherdemo.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.weatherdemo.R;


public class NextActivity extends BaseActivity {

    private Button mButton;
    private String TAG = this.getClass().getSimpleName();


    @Override
    public void onActivituCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_next);
        mButton = (Button) findViewById(R.id.show);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "当前有： " + mActivities);
            }
        });
    }
}
