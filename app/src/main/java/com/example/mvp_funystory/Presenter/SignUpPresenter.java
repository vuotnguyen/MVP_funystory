package com.example.mvp_funystory.Presenter;

import android.widget.Toast;

import com.example.mvp_funystory.DAO.CallUserDAO;
import com.example.mvp_funystory.Model.User;
import com.example.mvp_funystory.View.activity.App;

import java.util.List;

public class SignUpPresenter extends BasePresenter<CallUserDAO> {

    public static final String SUCCESS = "Đăng kí thành công";

    public SignUpPresenter(CallUserDAO callBack) {
        super(callBack);
    }
    public List<User> getAllUser(){
        return App.getInstance().getAppDB().getCallUser().getAllUsser();
    }
    public String signUp(String name, String phone,String pass,String rePass){
        String kq = "";
        if(name.isEmpty()==true || phone.isEmpty()==true || pass.isEmpty()==true || rePass.isEmpty()==true){
            return kq = "điền hết đi";
        }else{
            if(pass.length() <8 ){
                return kq = "pass trên 8 ký tự";
            }
            if(!pass.equals(rePass)){
                return kq = "pass chưa khớp";
            }
            List<User> listUser = getAllUser();
            for (int i = 0;i<listUser.size();i++){
                User user = listUser.get(i);
                if(name.equals(user.username)){
                    return kq = "tên đăng nhập đã tồn lại";
                }if(phone.equals(user.email)){
                    return kq = "mail đã được đăng kí";
                }
            }
        }
        return kq = SUCCESS;
    }
    public void insertUser(User user){
        App.getInstance().getAppDB().getCallUser().insertUser(user);
    }
}
