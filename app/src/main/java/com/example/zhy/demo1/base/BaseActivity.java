package com.example.zhy.demo1.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.zhy.demo1.mvp.base.BaseView;
import com.example.zhy.demo1.utils.MyToast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    private Unbinder mBinder;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResId());
        mBinder = ButterKnife.bind(this);
        init(savedInstanceState);
        // 初始化进度条
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("正在加载数据");
    }

    public abstract int getContentViewResId();

    public abstract void init(Bundle savedInstanceState);

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        MyToast.toast("请求错误");
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinder.unbind();
    }
}
