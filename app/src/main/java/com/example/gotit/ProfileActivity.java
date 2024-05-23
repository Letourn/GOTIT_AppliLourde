package com.example.gotit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewName = findViewById(R.id.textViewName);

        // Récupérer les données de l'intention
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        // Afficher les données
        textViewName.setText(name);
    }
}