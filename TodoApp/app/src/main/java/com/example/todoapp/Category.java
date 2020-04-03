package com.example.todoapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
}
