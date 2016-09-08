package com.chan.mm.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chan on 2016/9/6.
 */
public abstract class BaseActivity extends AppCompatActivity{
    public Context mContext;
    public Context mApplicationContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mContext = this;
        mApplicationContext = this.getApplicationContext();
        getIntentData();
        configApp();
        initViews();
        loadDatas();
        setListener();
    }

    /**
     * 配置一些app信息
     */
    public void configApp() {

    }

    protected abstract int getContentView();

    /**
     * 获取其他界面传过来的参数
     */
    public void getIntentData() {
    }

    /**
     * 设置监听
     */
    public abstract void setListener();

    /***
     * 加载数据
     */
    public abstract void loadDatas();

    /***
     * 获取到控件
     */
    public abstract void initViews();


}
