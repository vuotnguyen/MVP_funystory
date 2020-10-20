package com.example.mvp_funystory.Presenter;

import android.util.Log;

import com.example.mvp_funystory.DAO.CallHomeDAO;
import com.example.mvp_funystory.Model.CategoryStories;

import com.example.mvp_funystory.View.activity.App;

import java.util.List;

public class HomePresenter extends BasePresenter<CallHomeDAO> {
    public HomePresenter(CallHomeDAO callBack) {
        super(callBack);
    }


    public List<CategoryStories> getAllStory(){
        return App.getInstance().getAppDB().getStoryDAO().getAllCateStori();
    }
    public void insertStory(CategoryStories categoryStories){
        App.getInstance().getAppDB().getStoryDAO().insertStory(categoryStories);
    }

    public List<CategoryStories> getStoryByAnything(String anything){
        return null;
    }

    public boolean deleteStory(int id){
        return true;
    }

}
