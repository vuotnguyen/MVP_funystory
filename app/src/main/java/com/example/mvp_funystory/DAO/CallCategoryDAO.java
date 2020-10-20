package com.example.mvp_funystory.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvp_funystory.Model.Categories;
import com.example.mvp_funystory.View.CallBack.CallBack;

import java.util.List;

@Dao
public interface CallCategoryDAO extends CallBack {
    @Query("SELECT * FROM Categories")
    List<Categories> getALlStory();

    @Insert
    default void insertStory(Categories category){}

    @Delete
    default void deleteStory(Categories category){}

    @Delete
    default void deleteStoryByID(Categories id){}


}
