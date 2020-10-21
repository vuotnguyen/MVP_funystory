package com.example.mvp_funystory.View.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_PASS = "KEY_PASS";
    public static final String KEY_SIGNIN ="KEY_SIGNIN" ;
    private EditText edt_name,edt_pass;
    public static final String TAG = SignInFragment.class.getName();
    public static final String KEY_SHOW_SIGNUP = "SIGN_UP";
    private String kq;
    private int status;
    private CheckBox cbRemember;

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
        cbRemember = findViewById(R.id.cb_remember);

        SharedPreferences sharedPreferences =getActivity().getSharedPreferences(KEY_SIGNIN, Context.MODE_PRIVATE);
        edt_name.setText(sharedPreferences.getString(KEY_NAME,null));
        edt_pass.setText(sharedPreferences.getString(KEY_PASS,null));

    }

    @Override
    protected int getLayoutID() {
        return R.layout.sign_in_fragment;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btSignIn){
            kq = mpresenter.signIn(edt_name.getText().toString(),edt_pass.getText().toString());

            status = mpresenter.getType();
            getStorage().setStatus(status);

            Toast.makeText(getContext(),kq,Toast.LENGTH_SHORT).show();
            if(kq.equals(SignInPresenter.LOGINSUCCES)){
                checkRemember();
                even.gotoMainAct();
                even.destroyLogin();
            }
        }
        else if(v.getId() == R.id.tvSignUp){
            even.callBack(KEY_SHOW_SIGNUP,null);
        }
    }

    private void checkRemember() {
        if(cbRemember.isChecked() == true){
            SharedPreferences sharedPreferences =getActivity().getSharedPreferences(KEY_SIGNIN, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putString(KEY_NAME,edt_name.getText().toString());
            editor.putString(KEY_PASS,edt_pass.getText().toString());
            editor.commit();
        }
    }


}
