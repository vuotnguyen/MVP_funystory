package com.example.mvp_funystory.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"id"})
public class StoryComment {

    @NonNull
    @ColumnInfo(name = "id")
    public int id;


    @ColumnInfo(name = "story_id")
    public int story_id;


    @ColumnInfo(name = "comment_user")
    public String comment_user;


    @ColumnInfo(name = "comment_content")
    public String comment_content;
}
