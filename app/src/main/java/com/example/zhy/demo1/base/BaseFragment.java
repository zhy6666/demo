package com.example.zhy.demo1.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhy.demo1.mvp.base.BaseView;

public abstract class BaseFragment extends Fragment implements BaseView{

    private View mRootView;
    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMembersView(savedInstanceState);
        return mRootView;

    }

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    protected abstract int getContentViewId();

    @Override
    public void showLoading() {
        checkActivityAttached();
    }
    @Override
    public void hideLoading() {
        checkActivityAttached();
    }
    @Override
    public void showToast(String msg) {
        checkActivityAttached();
    }
    @Override
    public void showErr() {
        checkActivityAttached();
    }
    protected boolean isAttachedContext(){
        return getActivity() != null;
    }
    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }
    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }
}
