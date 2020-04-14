package com.example.jobdev;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Job.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract JobDao jobDao();
}
