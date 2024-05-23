package com.example.gotit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateUserActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonCreateUser = findViewById(R.id.buttonCreateUser);

        buttonCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void createUser() {
        String name = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
        } else {
            // Crée un une instance de la classe utilisateur
            Utilisateur utilisateur = new Utilisateur(name, password);

            // Enregistre l'utilisateur dans la base de données
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Appel de la base et réalisation de la requête
                    AppDatabase db = MainActivity.getDatabase();
                    db.utilisateurDao().insert(utilisateur);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(CreateUserActivity.this, "Utilisateur créé avec succès", Toast.LENGTH_SHORT).show();
                            // Retour à la page de connexion
                            Intent intent = new Intent(CreateUserActivity.this, MainActivity.class );
                            startActivity(intent);
                        }
                    });
                }
            }).start();
        }
    }
}