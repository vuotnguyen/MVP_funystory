package com.example.mvp_funystory.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvp_funystory.Model.User;
import com.example.mvp_funystory.View.CallBack.CallBack;

import java.util.List;

@Dao
public interface CallUserDAO extends CallBack {


    @Query("select * from User")
    List<User> getAllUsser();

    @Insert
    void insertUser(User user);
}
