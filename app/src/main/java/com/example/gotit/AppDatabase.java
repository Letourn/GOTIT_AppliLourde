package com.example.gotit;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Utilisateur.class, Poisson.class, Lieux.class, Log.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UtilisateurDao utilisateurDao();
    public abstract PoissonDao PoissonDao();
    public abstract LieuxDao LieuxDao();
    public abstract LogDao LogDao();
}
