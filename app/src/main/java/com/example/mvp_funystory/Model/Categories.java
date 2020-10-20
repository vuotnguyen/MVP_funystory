package com.example.mvp_funystory.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"id"})
public class Categories {

    @NonNull
    @ColumnInfo(name = "id")
    public int id;


    @ColumnInfo(name = "category_name")
    public String category_name;


    @ColumnInfo(name = "description")
    public String description;

    public Categories(int id, String category_name, String description) {
        this.id = id;
        this.category_name = category_name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(@NonNull String category_name) {
        this.category_name = category_name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}
