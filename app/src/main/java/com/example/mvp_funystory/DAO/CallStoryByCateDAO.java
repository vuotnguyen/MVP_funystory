package com.example.mvp_funystory.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.View.CallBack.CallBack;

import java.util.List;

@Dao
public interface CallStoryByCateDAO extends CallBack {

    @Query("select * from CategoryStories where category_id = :id")
    List<CategoryStories> getStoryByCate (int id);
}
