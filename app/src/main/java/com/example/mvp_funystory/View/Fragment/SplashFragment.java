package com.example.mvp_funystory.View.Fragment;

import android.os.Handler;
import android.view.View;

import com.example.mvp_funystory.CallBackPresenter.CallSplash;
import com.example.mvp_funystory.Presenter.SplashPresenter;
import com.example.mvp_funystory.R;

public class SplashFragment extends BaseFragment<SplashPresenter> implements CallSplash {
    public static final String KEY_SHOW_SIGNIN = "SIGN_IN";
    public static final String TAG = SplashFragment.class.getName();

    protected SplashPresenter getPresenter(){
        return new SplashPresenter(this);
    }

    @Override
    public SplashPresenter getMpresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                even.callBack(KEY_SHOW_SIGNIN,null);

            }
        },2000);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.splash_fragment;
    }

    @Override
    public void onClick(View v) {

    }

}
