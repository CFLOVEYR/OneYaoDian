package com.tofirst.jalen.oneyaodian.ui.fragment;


import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class YaoShowFragment extends BaseFragment {

    @Override
    public View initViews() {
        TextView textView = new TextView(mActivity);
        textView.setText("药店");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
        return textView;
    }
}
