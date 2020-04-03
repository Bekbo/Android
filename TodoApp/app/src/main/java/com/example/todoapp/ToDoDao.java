package com.example.todoapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ToDoDao {
    @Insert
    void insertToDo(ToDo toDo);

    @Query("Select * from todo")
    List<ToDo> getAll();

    @Query("Select * from todo where id = :id")
    ToDo getTodo(long id);

    @Query("Delete From todo where id = :id")
    void deleteToDo(long id);

    @Query("Update todo Set title = :title, duration =:duration, status = :status, description = :desc, cat_id = :cat where id = :id")
    void updateToDo(long id, String title, String duration, String status, String desc, int cat);
}
