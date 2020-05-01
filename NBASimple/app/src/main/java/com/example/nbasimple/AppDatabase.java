package com.example.nbasimple;
import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Team.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract TeamDao teamDao();
}
