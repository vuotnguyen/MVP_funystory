package com.example.mvp_funystory.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity (primaryKeys = {"id"})
public class User {

    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @NonNull
    @ColumnInfo(name = "password")
    public String password;


    @NonNull
    @ColumnInfo(name = "email")
    public String email;

    @NonNull
    @ColumnInfo(name = "status")
    public int status;

//    public User(@NonNull String username, @NonNull String password, @NonNull String email, int status) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.status = status;
//    }

    public User(int id, @NonNull String username, @NonNull String password, @NonNull String email, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
    }
}
