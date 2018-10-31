package com.example.zhy.demo1;

import android.app.Application;

import com.example.zhy.demo1.utils.MyToast;

public class App extends Application {

    private static App mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        MyToast.toast("jj");
        this.mInstance = this;
    }

    public static App getApp(){
        return mInstance;
    }
}
