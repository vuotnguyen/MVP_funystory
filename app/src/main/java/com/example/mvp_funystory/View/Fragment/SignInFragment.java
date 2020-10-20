package com.example.mvp_funystory.View.Fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_funystory.CallBackPresenter.CallSignIn;
import com.example.mvp_funystory.Presenter.SignInPresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.CallBack.CallBack;
import com.example.mvp_funystory.View.activity.Activity_Login;
import com.example.mvp_funystory.View.activity.MainActivity;

public class SignInFragment extends BaseFragment<SignInPresenter> implements CallSignIn {
    public static final String KEY_SHOW_HOME = "KEY_SHOW_HOME" ;
    private EditText edt_name,edt_pass;
    public static final String TAG = SignInFragment.class.getName();
    public static final String KEY_SHOW_SIGNUP = "SIGN_UP";
    private String kq;


    @Override
    public SignInPresenter getMpresenter() {
        return new SignInPresenter(this);
    }

    @Override
    protected void initView() {
        edt_name = findViewById(R.id.edtUser);
        edt_pass = findViewById(R.id.edtPass);
        findViewById(R.id.btSignIn,this);
        findViewById(R.id.tvSignUp,this);

    }

    @Override
    protected int getLayoutID() {
        return R.layout.sign_in_fragment;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btSignIn){
            kq = mpresenter.signIn(edt_name.getText().toString(),edt_pass.getText().toString());
            Toast.makeText(getContext(),kq,Toast.LENGTH_SHORT).show();
            if(kq.equals(SignInPresenter.LOGINSUCCES)){
//                even.callBack(KEY_SHOW_HOME,null);
                even.gotoMainAct();
                even.destroyLogin();
            }
        }
        else if(v.getId() == R.id.tvSignUp){
            even.callBack(KEY_SHOW_SIGNUP,null);
        }
    }


}
