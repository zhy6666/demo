package com.example.zhy.demo1.mvp;

import com.example.zhy.demo1.mvp.base.BaseView;

public interface IView extends BaseView{

    /**
     * 請求成功
     * @param result
     */
    void showData(String result);

}
