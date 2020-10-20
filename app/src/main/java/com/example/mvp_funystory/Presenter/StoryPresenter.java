package com.example.mvp_funystory.Presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.mvp_funystory.DAO.CallStoryDAO;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.Model.Story;
import com.example.mvp_funystory.View.activity.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StoryPresenter extends BasePresenter<CallStoryDAO> {
    private InputStream in;
    public StoryPresenter(CallStoryDAO callBack) {
        super(callBack);
    }

    public Story getStoryByID(int id){
        return App.getInstance().getAppDB().getCallStoryDAO().getStoryByID(id);
    }
    public void upDateData(String url,String content, int id){
        App.getInstance().getAppDB().getCallStoryDAO().upDateDATA(url,content,id);
    }
    public void insert(Story story){
        App.getInstance().getAppDB().getCallStoryDAO().insertStory(story);
    }
    public String getNameCate(int id){
        return App.getInstance().getAppDB().getCallStoryDAO().getNameCATE(id);
    }
    public CategoryStories geCSByID(int id){
        return App.getInstance().getAppDB().getCallStoryDAO().getCS(id);
    }
    public boolean delStoryByID(int id){
        return App.getInstance().getAppDB().getCallStoryDAO().deleteStoryByID(id);
    }
    public Bitmap getBitmapImage(Context context,int idStory){
        Bitmap bm = null;
        try {
            in = context.getAssets().open(getStoryByID(idStory).image_url);
            bm = BitmapFactory.decodeStream(in);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bm;
    }


    public StringBuilder getTextContent(Context context, int id) {
        StringBuilder text = new StringBuilder();
        try {
            in = context.getAssets().open(getStoryByID(id).content_introduce);
            BufferedReader buff = new BufferedReader(new InputStreamReader(in,"UTF8"));

            String line = buff.readLine();

            while (line!= null){
                text.append(line);
                line = buff.readLine();
            }
            in.close();
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
