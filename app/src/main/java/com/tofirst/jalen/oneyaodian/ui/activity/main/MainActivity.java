package com.tofirst.jalen.oneyaodian.ui.activity.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.tofirst.jalen.oneyaodian.R;
import com.tofirst.jalen.oneyaodian.ui.fragment.MainFragment;
import com.tofirst.jalen.oneyaodian.ui.fragment.MineFragMent;
import com.tofirst.jalen.oneyaodian.ui.fragment.YaoShowFragment;
import com.tofirst.jalen.oneyaodian.utils.ToastUtils;

public class MainActivity extends BaseActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;

    private Class[] fragmentArray;
    private int[] mImageViewArray;
    private String[] mTextviewArray;
    private long firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEventLister();
    }

    @Override
    public void initView() {
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        //得到Fragment的个数
        int count = fragmentArray.length;

        //取消分割线
        mTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < count; i++) {
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
        }
    }

    @Override
    public void initData() {
        //定义数组来存放Fragment界面
        fragmentArray = new Class[]{MainFragment.class, YaoShowFragment.class, MineFragMent.class};

        //定义数组来存放按钮数据
        mImageViewArray = new int[]{R.drawable.tab_tiku_btn_selector, R.drawable.tab_zixun_btn_selector, R.drawable.tab_wode_btn_selector};

        //Tab选项卡的文字
        mTextviewArray = getResources().getStringArray(R.array.bottom_tab);
    }


    @Override
    public void initEventLister() {

    }

    /**
     * 给Tab按钮设置图标和文字
     */

    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.layout_item_tab_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
        return view;
    }

    /**
     * 判断二次退出的功能实现
     */
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            firstTime = secondTime;
            ToastUtils.showToast("再按一次退出");
        } else {
            finish();
        }
    }
}
