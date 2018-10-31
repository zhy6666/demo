package com.example.zhy.demo1.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zhy.demo1.R;
import com.example.zhy.demo1.base.BaseActivity;
import com.example.zhy.demo1.mvp.IPresenter;
import com.example.zhy.demo1.mvp.IView;
import com.example.zhy.demo1.utils.MyToast;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements IView {

    @BindView(R.id.tv_success)
    TextView mTextView1;

    @BindView(R.id.tv_failure)
    TextView mTextView2;

    private IPresenter mPresenter;

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
       mPresenter = new IPresenter();
       mPresenter.attachView(this);
    }

    @OnClick(R.id.tv_success)
    protected void click1(){
        mPresenter.getData("1");
    }

    @OnClick(R.id.tv_failure)
    protected void click2(){
        mPresenter.getData("2");
    }

    @Override
    public void showData(String result) {
        mTextView1.setText(result);
    }

    @Override
    public void showToast(String msg) {
        super.showToast(msg);
        MyToast.toast("请求失败");
    }
}
