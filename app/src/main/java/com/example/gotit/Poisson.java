package com.example.gotit;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "poissons")
public class Poisson {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nom;
    public String nomlatin;
    public String description;

    // Constructeur
    public Poisson(String nom, String nomlatin, String description) {
        this.nom = nom;
        this.nomlatin = nomlatin;
        this.description = description;

    }
}
