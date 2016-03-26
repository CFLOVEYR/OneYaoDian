package com.tofirst.jalen.oneyaodian.ui.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tofirst.jalen.oneyaodian.R;
import com.tofirst.jalen.oneyaodian.mannager.AppMannager;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        AppMannager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppMannager.getAppManager().removeActivity(this);
    }

    public abstract void initView();

    public abstract void initData();

    public abstract void initEventLister();

}
