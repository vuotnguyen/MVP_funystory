package com.example.mvp_funystory.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.sql.Date;

@Entity(primaryKeys = {"id"})
public class Story {
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "story_id")
    public int story_id;

    @NonNull
    @ColumnInfo(name = "category_id")
    public int category_id;

    @NonNull
    @ColumnInfo(name = "created_date")
    public String created_date;

    @ColumnInfo(name = "image_url")
    public String image_url;

    @NonNull
    @ColumnInfo(name = "modified_date")
    public String modified_date;


    @ColumnInfo(name = "status")
    public int status;


    @ColumnInfo(name = "content_introduce")
    public String content_introduce;

    public Story(int id, int story_id, int category_id, @NonNull String created_date, String image_url, @NonNull String modified_date, int status, String content_introduce) {
        this.id = id;
        this.story_id = story_id;
        this.category_id = category_id;
        this.created_date = created_date;
        this.image_url = image_url;
        this.modified_date = modified_date;
        this.status = status;
        this.content_introduce = content_introduce;
    }
}
