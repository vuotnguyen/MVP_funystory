package com.example.mvp_funystory.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"id"})
public class StoryContent {

    @NonNull
    @ColumnInfo(name = "id")
    public int id;


    @ColumnInfo(name = "story_id")
    public int story_id;


    @ColumnInfo(name = "chapter")
    public String chapter;


    @ColumnInfo(name = "chapter_name")
    public String chapter_name;


    @ColumnInfo(name = "story_content")
    public String story_content;

    public StoryContent(int id, int story_id, String chapter, String chapter_name, String story_content) {
        this.id = id;
        this.story_id = story_id;
        this.chapter = chapter;
        this.chapter_name = chapter_name;
        this.story_content = story_content;
    }
}
