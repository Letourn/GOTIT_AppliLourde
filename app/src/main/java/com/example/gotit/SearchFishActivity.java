package com.example.gotit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchFishActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUsers;
    private FishAdapter fishAdapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_list);

        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));

        AppDatabase db = MainActivity.getDatabase();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Appel de la fonction de PoissonDao faisant la requête à la BD
                List<Poisson> poissons = db.PoissonDao().getAllPoissons();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Affichage des poissons dans la liste
                        fishAdapter = new FishAdapter(poissons);
                        recyclerViewUsers.setAdapter(fishAdapter);
                    }
                });
            }
        }).start();
    }
}