package com.example.mvp_funystory.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvp_funystory.Model.StoryContent;
import com.example.mvp_funystory.View.CallBack.CallBack;

import java.util.List;

@Dao
public interface CallStoryContent extends CallBack {
    @Query("select * from StoryContent where chapter = :chapter ")
    StoryContent getStoryContent(int chapter);
}
