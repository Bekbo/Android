package com.example.todoapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert
    void insertCategory(Category category);

    @Query("Select * from category")
    List<Category> getAll();

    @Query("Select * from category where id = :id")
    Category getCategory(long id);

    @Delete
    void deleteCategory(Category category);

    @Update
    void updateCategory(Category category);
}
