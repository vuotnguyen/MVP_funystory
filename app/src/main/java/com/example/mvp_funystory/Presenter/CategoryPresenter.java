package com.example.mvp_funystory.Presenter;

import com.example.mvp_funystory.DAO.CallCategoryDAO;
import com.example.mvp_funystory.Model.Categories;
import com.example.mvp_funystory.View.activity.App;

import java.util.List;

public class CategoryPresenter extends BasePresenter<CallCategoryDAO> {
    public CategoryPresenter(CallCategoryDAO callBack) {
        super(callBack);
    }
    public List<Categories> getAllCategory(){
        return App.getInstance().getAppDB().getCategoryDAO().getALlStory();
    }
    public void insert(Categories categories){
        App.getInstance().getAppDB().getCategoryDAO().insertStory(categories);

    }
    public boolean deleteCategory(int id){
        return false;
    }
    public boolean upDateCategory(String name,String des){
        return false;
    }
}
