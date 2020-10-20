package com.example.mvp_funystory.View.CallBack;

public interface CallBack {
    default void callBack(String key, Object data){

    }
    default void gotoStory(int category_id){

    }
    default void gotoStoryByCate(int id){}

    default void gotoMainAct(){}

    default  void destroyLogin(){}

    default void showDrawerMenu(){}
}
