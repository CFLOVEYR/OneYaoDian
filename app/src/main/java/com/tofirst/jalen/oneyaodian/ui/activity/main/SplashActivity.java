package com.tofirst.jalen.oneyaodian.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.tofirst.jalen.oneyaodian.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initData();
        initView();
        initEventLister();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEventLister() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                SystemClock.sleep(1000);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}
