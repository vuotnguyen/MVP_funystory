package com.example.mvp_funystory.Presenter;

import com.example.mvp_funystory.View.CallBack.CallBack;

public abstract class BasePresenter<T extends CallBack> {
    protected T viewFragment;

    public BasePresenter(T callBack){
        viewFragment = callBack;
    }

    public BasePresenter() {

    }
}
