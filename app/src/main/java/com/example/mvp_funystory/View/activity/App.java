package com.example.mvp_funystory.View.activity;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.example.mvp_funystory.database.AppDB;

public class App extends Application {
    protected AppDB appDB;
    private static App instance;
    private StorageCommon storageCommon;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        storageCommon = new StorageCommon();
         initDB();
    }

    private void initDB() {
        appDB = Room.databaseBuilder(getApplicationContext(),AppDB.class,"database").allowMainThreadQueries().createFromAsset("fullstory1.db").build();
        Log.i("TAG", "initDB: kết nối thành công");
    }

    public AppDB getAppDB() {
        return appDB;
    }

    public static App getInstance() {
        return instance;
    }

    public StorageCommon getStorageCommon() {
        return storageCommon;
    }
}
