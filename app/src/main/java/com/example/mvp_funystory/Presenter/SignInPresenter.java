package com.example.mvp_funystory.Presenter;

import android.util.Log;

import com.example.mvp_funystory.CallBackPresenter.CallSignIn;
import com.example.mvp_funystory.Model.User;
import com.example.mvp_funystory.View.activity.App;

import java.util.List;

public class SignInPresenter extends BasePresenter<CallSignIn> {
    public static final String LOGINSUCCES = "Login success";
    private String rs;
    private boolean kq;
    private int type;
    public SignInPresenter(CallSignIn callBack) {
        super(callBack);
    }

    public List<User> getAllUser(){
        return App.getInstance().getAppDB().getCallUser().getAllUsser();
    }

    public String signIn(String name,String pass){
        List<User> listUsser = getAllUser();

        if(name.isEmpty() == true ||pass.isEmpty() == true){
            return rs = "điền hết vào đê";
        }else{
            for (int i = 0; i < listUsser.size()-1;i++){
                User user = listUsser.get(i);
                Log.i("TAG", "signIn: "+user.username);
                type = user.status;
                if(name.equals(user.username) && pass.equals(user.password)){
                    return  rs = "Login success";
                }
            }
        }
        return "sai pass or name";
    }

    public int getType() {
        return type;
    }
}
