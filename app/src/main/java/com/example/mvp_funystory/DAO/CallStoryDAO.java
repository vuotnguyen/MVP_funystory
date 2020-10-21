package com.example.mvp_funystory.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;

import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.Model.Story;
import com.example.mvp_funystory.View.CallBack.CallBack;
@Dao
public interface CallStoryDAO extends CallBack {
    @Query("SELECT * FROM Story WHERE id = :id")
    Story getStoryByID(int id);

    @Query("UPDATE Story SET image_url = :url AND content_introduce = :content WHERE id = :id  ")
    default  void upDateDATA(String url,String content, int id){}

    @Insert
    void insertStory(Story story);

    @Query("SELECT * FROM CategoryStories WHERE id = :id")
    CategoryStories getCS(int id);

    @Query("SELECT ca.category_name FROM Categories ca WhERE id = :id")
    default String getNameCATE(int id){
        return null;
    }
    @Delete
    default boolean deleteStoryByID(Story story){
        return true;
    }
}
