package com.example.mvp_funystory.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mvp_funystory.DAO.CallCategoryDAO;
import com.example.mvp_funystory.DAO.CallHomeDAO;
import com.example.mvp_funystory.Convert.DateConverter;
import com.example.mvp_funystory.DAO.CallStoryByCateDAO;
import com.example.mvp_funystory.DAO.CallStoryContent;
import com.example.mvp_funystory.DAO.CallStoryDAO;
import com.example.mvp_funystory.DAO.CallTotalChapter;
import com.example.mvp_funystory.DAO.CallUserDAO;
import com.example.mvp_funystory.Model.Categories;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.Model.StoriesHistory;
import com.example.mvp_funystory.Model.Story;
import com.example.mvp_funystory.Model.StoryComment;
import com.example.mvp_funystory.Model.StoryContent;
import com.example.mvp_funystory.Model.User;

import java.util.List;

@Database(entities = {Categories.class, CategoryStories.class, StoriesHistory.class, Story.class, StoryComment.class, StoryContent.class, User.class},version = 1,exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDB extends RoomDatabase {
    public abstract CallHomeDAO getStoryDAO();
    public abstract CallCategoryDAO getCategoryDAO();
    public abstract CallStoryDAO getCallStoryDAO();
    public abstract CallStoryContent getCallStoryContent();
    public abstract CallTotalChapter getCallTotalChapter();
    public abstract CallStoryByCateDAO getCallStoryByCate();
    public abstract CallUserDAO getCallUser();
}
