package com.example.mvp_funystory.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.View.CallBack.CallBack;

import java.util.List;
@Dao
public interface CallHomeDAO extends CallBack {

//    void showStorySearch(String thing);

    @Query("SELECT * FROM CategoryStories")
    List<CategoryStories> getAllCateStori();

    @Insert
    void insertStory(CategoryStories categorystories);

    @Delete
    default void deleteStory(CategoryStories categorystories){}

    @Delete
    default boolean deleteStoryCateByID(int id){
        return true;
    }
}
