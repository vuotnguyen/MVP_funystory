package com.example.mvp_funystory.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvp_funystory.Model.StoryContent;
import com.example.mvp_funystory.View.CallBack.CallBack;

import java.util.List;

@Dao
public interface CallTotalChapter extends CallBack {

    @Query("Select * from StoryContent where story_id = :id")
    List<StoryContent> getStoryContentById(int id);

    @Insert
    void insertStory(StoryContent content);

    @Query("update StoryContent set chapter = :chapter and story_id = :idStory where id = :id")
    void updateStoryContent(String chapter, int idStory, int id);

    @Query("delete from StoryContent")
    void delAll();
}
