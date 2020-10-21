package com.example.mvp_funystory.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.CallBack.CallBack;
import com.example.mvp_funystory.View.Fragment.BaseFragment;
import com.example.mvp_funystory.View.Fragment.SignInFragment;
import com.example.mvp_funystory.View.Fragment.SplashFragment;
import com.example.mvp_funystory.View.Fragment.UserDAOFragment;

public class Activity_Login extends AppCompatActivity implements CallBack {

    private String currenTag;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        initView();
    }

    private void initView() {
        showFragment(SplashFragment.TAG);
    }
    public void showFragment(String tag) {
        try {
            Class<?> clazz = Class.forName(tag);
            BaseFragment baseFragment = (BaseFragment) clazz.newInstance();
            baseFragment.setCallBack(this);
            currenTag = tag;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            transaction.replace(R.id.ln_login,baseFragment,tag).commit();
            transaction.addToBackStack(baseFragment.getClass().getName());
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void callBack(String key, Object data) {
        switch (key){
            case SplashFragment.KEY_SHOW_SIGNIN:
                showFragment(SignInFragment.TAG);
                break;
            case SignInFragment.KEY_SHOW_SIGNUP:
                showFragment(UserDAOFragment.TAG);
                break;
        }
    }

    @Override
    public void gotoMainAct() {
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void destroyLogin() {
        finish();
    }
}