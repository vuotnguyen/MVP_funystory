package com.example.mvp_funystory.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.sql.Date;

@Entity (primaryKeys = {"id"})
public class StoriesHistory {
    @NonNull
    @ColumnInfo(name = "id")
    public int id;


    @ColumnInfo(name = "story_id")
    public int story_id;


    @ColumnInfo(name = "story_user")
    public String story_user;

    @NonNull
    @ColumnInfo(name = "reading_time")
    public String reading_time;
}
