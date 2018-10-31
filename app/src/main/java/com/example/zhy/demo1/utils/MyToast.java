package com.example.zhy.demo1.utils;

import android.widget.Toast;

import com.example.zhy.demo1.App;

public class MyToast  {

    public static void toast(String str){
        Toast.makeText(App.getApp(),str,Toast.LENGTH_SHORT).show();
    }
}
