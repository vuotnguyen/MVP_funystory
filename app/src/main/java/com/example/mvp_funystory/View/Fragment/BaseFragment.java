package com.example.mvp_funystory.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvp_funystory.Presenter.BasePresenter;
import com.example.mvp_funystory.View.CallBack.CallBack;
import com.example.mvp_funystory.View.activity.App;
import com.example.mvp_funystory.View.activity.StorageCommon;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements View.OnClickListener {
    protected Context context;
    protected View view;
    protected CallBack even;
    protected T mpresenter;

    public final void setCallBack(CallBack callBack){
        even = callBack;
    }

    public abstract T getMpresenter();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutID(),container,false);
        initView();
        mpresenter = getMpresenter();
        return view;
    }
    protected final <T extends View> T findViewById(int id, View.OnClickListener even){
        T v = view.findViewById(id);
        if(even != null){
            v.setOnClickListener(even);
        }
        return v;
    }
    protected final <T extends View> T findViewById(int id){
        T v = view.findViewById(id);
        return v;
    }


    protected abstract void initView();

    protected abstract int getLayoutID();

    public StorageCommon getStorage(){
        return App.getInstance().getStorageCommon();
    }
}
