package com.tofirst.jalen.oneyaodian.application;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        initSDK();
    }

    private void initSDK() {

    }

    public static BaseApplication getApplication() {
        return mContext;
    }
}
