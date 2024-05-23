package com.example.gotit;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "lieux")
public class Lieux {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nom;
    public float latitude;
    public float longitude;

    // Constructeur
    public Lieux(String nom, float latitude, float longitude) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;

    }
}
