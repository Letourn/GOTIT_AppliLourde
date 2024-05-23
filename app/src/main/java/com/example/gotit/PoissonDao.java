package com.example.gotit;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// DAO permettant d'intéragir avec la BD
@Dao
public interface PoissonDao {
    @Insert
    void insert(Poisson poisson);

    @Query("SELECT * FROM poissons")
    List<Poisson> getAllPoissons();

    @Query("SELECT * FROM poissons WHERE nom = :name AND nomlatin = :latinname LIMIT 1")
    Poisson findByNameOrLatinName(String name, String latinname);

}
