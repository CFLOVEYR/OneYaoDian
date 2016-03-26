package com.tofirst.jalen.oneyaodian.utils;

import android.widget.Toast;

import com.tofirst.jalen.oneyaodian.application.BaseApplication;


/**
 * 弹出框的工具类
 */
public class ToastUtils {

    private ToastUtils() {
    }

    public static void showToast(CharSequence text) {
        if (text.length() < 10) {
            Toast.makeText(BaseApplication.getApplication(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(BaseApplication.getApplication(), text, Toast.LENGTH_LONG).show();
        }
    }

}
