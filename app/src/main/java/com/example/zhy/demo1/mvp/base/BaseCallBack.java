package com.example.zhy.demo1.mvp.base;

public interface BaseCallBack<T> {

    /**
     * 成功回调
     * @param data
     */
    void onSuccess(T data);

    /**
     * 失败回调
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 請求藉口結束
     */
    void onComplete();
}

