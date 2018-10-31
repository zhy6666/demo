package com.example.zhy.demo1.mvp;

import com.example.zhy.demo1.mvp.base.BaseCallBack;
import com.example.zhy.demo1.mvp.base.BasePresenter;

public class IPresenter extends BasePresenter<IView>{

    public void getData(String params){
        if (!isViewAttached()){
            //如果没有View引用就不加载数据
            return;
        }
        getView().showLoading();

        IModel.getData(params, new BaseCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                if(isViewAttached()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if(isViewAttached()) {
                    getView().showToast(msg);
                }
            }

            @Override
            public void onComplete() {
                if(isViewAttached()){
                    getView().hideLoading();
                }
            }
        });
    }
}
