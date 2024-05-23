package com.example.gotit;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Classe Utilisateur de la table Utilisateur
@Entity(tableName = "utilisateurs")
public class Utilisateur {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nom;
    public String motDePasse;

    // Constructeur
    public Utilisateur(String nom, String motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }
}
