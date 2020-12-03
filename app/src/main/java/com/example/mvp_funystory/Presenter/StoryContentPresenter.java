package com.example.mvp_funystory.Presenter;

import android.content.Context;

import com.example.mvp_funystory.DAO.CallStoryContent;
import com.example.mvp_funystory.Model.StoryContent;
import com.example.mvp_funystory.View.activity.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StoryContentPresenter extends BasePresenter<CallStoryContent> {
    private InputStream in;
    public StoryContentPresenter(CallStoryContent callBack) {
        super(callBack);
    }


    public StoryContent getStoryContent(int chapter){
        return App.getInstance().getAppDB().getCallStoryContent().getStoryContent(chapter);
    }

    public String getContentText(int chapter, Context context) {
        String text = null;
        StringBuilder rs = new StringBuilder();
        try {
           in = context.getAssets().open(getStoryContent(chapter).story_content);
            BufferedReader buff = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            String line = buff.readLine();
            while (line != null){
                rs.append(line+"\n");
                line = buff.readLine();
            }
            text = String.valueOf(rs);

            System.out.println(text);
            in.close();
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }



}
