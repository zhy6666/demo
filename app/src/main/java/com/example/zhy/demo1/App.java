package com.example.zhy.demo1;

import android.app.Application;

public class App extends Application {

    private static App mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        this.mInstance = this;
    }

    public static App getApp(){
        return mInstance;
    }
}
