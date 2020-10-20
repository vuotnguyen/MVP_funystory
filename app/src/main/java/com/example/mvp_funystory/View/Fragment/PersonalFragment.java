package com.example.mvp_funystory.View.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mvp_funystory.Presenter.PersonalPresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.CallBackPresenter.CallPersonal;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonalFragment extends BaseFragment<PersonalPresenter> implements CallPersonal {
    public static final String TAG = PersonalFragment.class.getName() ;
    public static final String KEY_SHOW_PERSONAL = "KEY_SHOW_PERSONAL";
    public static final String KEY_AVARTAR = "KEY_AVARTAR";
    public static final String KEY_PATH = "KEY_PATH";

    private TextView tvTitle;
    private ImageView imgAvartar;
    private String bm;
    private TextView tvInfo,tvSendMail,tvRate,tvTutorial,tvSignIn;

    @Override
    public PersonalPresenter getMpresenter() {
        return new PersonalPresenter(this);
    }

    @Override
    protected void initView() {
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Cá nhân");

        imgAvartar = findViewById(R.id.img_Avatar_User,this);
        tvInfo = findViewById(R.id.tv_info,this);
        tvSendMail = findViewById(R.id.tv_sendMail,this);
        tvRate = findViewById(R.id.tv_rate,this);
        tvTutorial = findViewById(R.id.tv_use,this);
        tvSignIn = findViewById(R.id.tv_signIn,this);

        saveAvartar();

    }

    private void saveAvartar() {
        SharedPreferences sharedPreferences =getActivity().getSharedPreferences(KEY_AVARTAR, Context.MODE_PRIVATE);
         bm = sharedPreferences.getString(KEY_PATH,null);
        imgAvartar.setImageBitmap(BitmapFactory.decodeFile(bm));
    }

    @Override
    protected int getLayoutID() {
        return R.layout.personal_frament;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Avatar_User:
                chooseImageAvartar();
                break;
            case R.id.tv_info:
                showInfo();
                break;
            case R.id.tv_sendMail:
                sendMail();
                break;
            case R.id.tv_rate:
                rateApp();
                break;
            case R.id.tv_use:
               useApp();
                break;
            case R.id.tv_signIn:
               signIn();
               break;
        }

    }

    private void signIn() {
    }

    private void useApp() {
    }

    private void rateApp() {
    }

    private void sendMail() {
    }

    private void showInfo() {
    }

    private void chooseImageAvartar() {
        checkAndRequestPermissions();
        getStorage().setTagFrag(TAG);
        even.callBack(ChooseImagesFragment.KEY_SHOW_IMAGES,null);

    }
    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(getContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(getActivity(), listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }
}
