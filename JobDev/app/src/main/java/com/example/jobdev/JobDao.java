package com.example.jobdev;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JobDao {
    @Insert
    void addJob(Job job);

    @Query("Select * from job")
    List<Job> getJobs();

    @Query("Select * from job where id = :id")
    Job getJob(String id);

    @Query("Delete from job where id = :id")
    void deleteJob(String id);
}
