package com.example.gotit;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// DAO permettant d'intéragir avec la BD
@Dao
public interface UtilisateurDao {
    @Insert
    void insert(Utilisateur utilisateur);

    @Query("SELECT * FROM utilisateurs")
    List<Utilisateur> getAllUtilisateurs();

    @Query("SELECT * FROM utilisateurs WHERE nom = :name AND motDePasse = :motDePasse LIMIT 1")
    Utilisateur findByNameAndPassword(String name, String motDePasse);
}
