package com.example.zhy.demo1.mvp;


import android.os.Handler;

import com.example.zhy.demo1.mvp.base.BaseCallBack;

public class IModel {

    public static void getData(final String param, final BaseCallBack<String> mvpCallBack){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){
                    case "1":
                        mvpCallBack.onSuccess("请求成功");
                        break;
                    case "2":
                        mvpCallBack.onFailure("请求失败");
                        break;
                }
                mvpCallBack.onComplete();

            }
        },2000);
    }
}
