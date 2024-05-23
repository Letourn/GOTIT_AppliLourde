package com.example.gotit;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface LieuxDao {
    @Insert
    void insert(Lieux lieux);

    @Query("SELECT * FROM lieux")
    List<Lieux> getAllLieux();
}
