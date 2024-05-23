package com.example.gotit;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

// Classe Utilisateur de la table Utilisateur
@Entity(tableName = "logs")
public class Log {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String Action;
    public String Description;
    public Date Date;
    public String Adresse_IP;

    // Constructeur
    public Log(String Action, String Description, Date Date, String Adresse_IP) {
        this.Action = Action;
        this.Description = Description;
        this.Date = Date;
        this.Adresse_IP = Adresse_IP;
    }
}

