package com.example.todoapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ToDo.class, Category.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ToDoDao toDoDao();
    public abstract CategoryDao categoryDao();


}
