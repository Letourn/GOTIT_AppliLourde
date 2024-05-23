package com.example.gotit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    private static AppDatabase database;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Création de la base de donnée
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "GOTIT_DATABASE").build();
        setContentView(R.layout.activity_main);

        // Récupération du nom d'utilisateur connecté
        Intent username = getIntent();
        String name = username.getStringExtra("name");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        setSupportActionBar(findViewById(R.id.toolbar));

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    Toast.makeText(MainActivity.this, "Accueil selectionné", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class );
                    intent.putExtra("name", name);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.map) {
                    Toast.makeText(MainActivity.this, "Carte selectionné", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class );
                    startActivity(intent);
                    return true;                }
                else if (itemId == R.id.gallery) {
                    Toast.makeText(MainActivity.this, "Poissons selectionné", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SearchFishActivity.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.account) {
                    if (name == null) {
                        Toast.makeText(MainActivity.this, "Veuillez d'abord vous connecter", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Mon compte selectionné", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                        return true;
                    }
                } else if (itemId == R.id.log) {
                    Toast.makeText(MainActivity.this, "Se connecter selectionné", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ConnectActivity.class );
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.about) {
                    Toast.makeText(MainActivity.this, "À propos de nous selectionné", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen((GravityCompat.START)))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    // Méthode permettant d'utiliser la BD dans les autres activités
    public static AppDatabase getDatabase() {
        return database;
    }
}