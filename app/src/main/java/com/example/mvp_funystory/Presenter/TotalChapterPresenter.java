package com.example.mvp_funystory.Presenter;

import com.example.mvp_funystory.DAO.CallTotalChapter;
import com.example.mvp_funystory.Model.StoryContent;
import com.example.mvp_funystory.View.activity.App;

import java.util.List;

public class TotalChapterPresenter extends BasePresenter<CallTotalChapter> {
    public TotalChapterPresenter(CallTotalChapter callBack) {
        super(callBack);
    }
    public List<StoryContent> getStoryContentByID(int id){
        return App.getInstance().getAppDB().getCallTotalChapter().getStoryContentById(id);
    }

    public void insertContentStory(StoryContent content) {
        App.getInstance().getAppDB().getCallTotalChapter().insertStory(content);
    }

    public void updateStoryContent(String chap,int idStory ,int id){
        App.getInstance().getAppDB().getCallTotalChapter().updateStoryContent(chap,idStory,id);
    }
    public void delAll(){
        App.getInstance().getAppDB().getCallTotalChapter().delAll();
    }
}
