package com.example.mvp_funystory.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;


@Entity(primaryKeys ={"id"})
public class CategoryStories {

    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "category_id")
    private int category_id;


    @ColumnInfo(name = "story_name")
    private String story_name;


    @ColumnInfo(name = "total_chapter")
    private int total_chapter;


    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "modified_date")
    private String modified_date;

    public int getId() {
        return id;
    }

    public int getCategory_id() {
        return category_id;
    }

    @NonNull
    public String getStory_name() {
        return story_name;
    }

    public int getTotal_chapter() {
        return total_chapter;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getModified_date() {
        return modified_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setStory_name(String story_name) {
        this.story_name = story_name;
    }

    public void setTotal_chapter(int total_chapter) {
        this.total_chapter = total_chapter;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setModified_date(String modified_date) {
        this.modified_date = modified_date;
    }

    public CategoryStories(int id, int category_id, String story_name, int total_chapter, String author, String modified_date) {
        this.id = id;
        this.category_id = category_id;
        this.story_name = story_name;
        this.total_chapter = total_chapter;
        this.author = author;
        this.modified_date = modified_date;
    }
}
