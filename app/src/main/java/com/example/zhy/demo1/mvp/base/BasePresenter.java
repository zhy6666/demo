package com.example.zhy.demo1.mvp.base;


public class BasePresenter<V extends BaseView> {

    private V mvpView;

    /**
     * 注入view
     * @param view
     */
    public void attachView(V view){
        this.mvpView = view;
    }

    /**
     * 解綁view
     */
    public void destoryView(){
        this.mvpView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mvpView != null;
    }

    /**
     * 获取连接的view
     */
    public V getView(){
        return mvpView;
    }


}
