package com.example.nbasimple;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface TeamDao {
    @Insert
    void addTeam(Team team);

    @Query("Select * from team")
    List<Team> getTeams();

    @Query("Select * from team where id = :id")
    Team getTeam(int id);

    @Query("Delete from team where id = :id")
    void deleteTeam(int id);
}
