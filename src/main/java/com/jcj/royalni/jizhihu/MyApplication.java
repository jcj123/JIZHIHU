package com.jcj.royalni.jizhihu;

import android.app.Application;

/**
 * Created by Royal Ni on 2017/5/7.
 */

public class MyApplication extends Application{
    private static MyApplication mApplication;

    public static MyApplication getInstance(){
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
}
