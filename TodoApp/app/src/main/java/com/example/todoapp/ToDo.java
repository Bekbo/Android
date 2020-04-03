package com.example.todoapp;
import androidx.room.ColumnInfo;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {
        @ForeignKey(entity = Category.class,
                parentColumns = {"id"},
                childColumns = {"cat_id"},
                onDelete = CASCADE)}
        ,indices = {@Index("cat_id")
        }
    )
public class ToDo {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String description;
    public String status;
    public int cat_id;
    public String duration;
}
