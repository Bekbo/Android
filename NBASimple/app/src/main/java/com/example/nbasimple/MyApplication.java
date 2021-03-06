package com.example.nbasimple;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    public static MyApplication instance;
    private AppDatabase appDatabase;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "Job_db")
                .allowMainThreadQueries()
                .build();
    }

    public static MyApplication getInstance(){
        return instance;
    }

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
