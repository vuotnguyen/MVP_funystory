package com.example.mvp_funystory.CallBackPresenter;

import android.graphics.Bitmap;

import com.example.mvp_funystory.View.CallBack.CallBack;

public interface CallImage extends CallBack {
    default void sendBM(String bm){}
    default void gobackInsert(String bm){}
}
