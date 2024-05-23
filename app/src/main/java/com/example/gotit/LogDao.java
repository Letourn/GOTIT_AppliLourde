package com.example.gotit;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface LogDao {
    @Insert
    void insert(Log Log);

    @Query("SELECT * FROM logs")
    List<Log> getAllLLogs();
}