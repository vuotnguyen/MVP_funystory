package com.example.mvp_funystory.Presenter;

import com.example.mvp_funystory.DAO.CallStoryByCateDAO;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.View.activity.App;

import java.util.List;

public class StoryByCatePresenter extends BasePresenter<CallStoryByCateDAO> {
    public StoryByCatePresenter(CallStoryByCateDAO callBack) {
        super(callBack);
    }
    public List<CategoryStories> getStoryByCate(int id){
        return App.getInstance().getAppDB().getCallStoryByCate().getStoryByCate(id);
    }
}
