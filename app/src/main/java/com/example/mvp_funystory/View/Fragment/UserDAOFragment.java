package com.example.mvp_funystory.View.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_funystory.DAO.CallUserDAO;
import com.example.mvp_funystory.Model.User;
import com.example.mvp_funystory.Presenter.SignUpPresenter;
import com.example.mvp_funystory.R;

import java.util.List;

public class UserDAOFragment extends BaseFragment<SignUpPresenter> implements CallUserDAO {

    public static final String TAG = UserDAOFragment.class.getName() ;
    private EditText edtName,edtMail,edtPass,edtRepass;
    private String name,mail,pass,rePass;

    @Override
    public SignUpPresenter getMpresenter() {
        return new SignUpPresenter(this);
    }

    @Override
    protected void initView() {
        //insertUser(new User("admin","admin","admin",0));
//        insertUser(new User(2,"admin1","admin1","admin1",0));
//        insertUser(new User(3,"admin2","admin2","admin2",0));
//        insertUser(new User(4,"hien","15111996","thaohienbit",1));

        findViewById(R.id.btSignUp,this);
        edtName = findViewById(R.id.edtUserLogin);
        edtMail = findViewById(R.id.edtPhone);
        edtPass = findViewById(R.id.edtPassLogin);
        edtRepass = findViewById(R.id.edtRePass);


    }

    @Override
    protected int getLayoutID() {
        return R.layout.sign_up_fragment;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btSignUp){
            signUpUser();
        }
    }

    private void signUpUser() {
        name = edtName.getText().toString();
        mail = edtMail.getText().toString();
        pass = edtPass.getText().toString();
        rePass = edtRepass.getText().toString();
        String rs = getMpresenter().signUp(name,mail,pass,rePass);
        Toast.makeText(getContext(),rs,Toast.LENGTH_SHORT).show();
        if(rs.equals(SignUpPresenter.SUCCESS)){
            insertUser(new User(getAllUsser().size()+1,name,pass,mail,1));
            even.callBack(SplashFragment.KEY_SHOW_SIGNIN,null);
        }
    }

    @Override
    public List<User> getAllUsser() {
        return getMpresenter().getAllUser();
    }

    @Override
    public void insertUser(User user) {
        getMpresenter().insertUser(user);
    }
}
