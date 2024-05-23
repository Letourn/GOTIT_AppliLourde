package com.example.gotit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonConnect;
    private Button buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonConnect = findViewById(R.id.buttonConnect);
        buttonCreate = findViewById(R.id.buttonCreate);

        // Listener du bouton de connexion
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // Listener du bouton Créer un utilisateur
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectActivity.this, CreateUserActivity.class );
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        String name = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Vérif si les champs sont remplis
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Connexion à la BD
                    AppDatabase db = MainActivity.getDatabase();
                    // Création d'un objet Utilisateur basé sur le réponse de la requête cherchant l'utilisateur enfonction des identifiants trouvés
                    Utilisateur utilisateur = db.utilisateurDao().findByNameAndPassword(name, password);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (utilisateur != null) {
                                Toast.makeText(ConnectActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                                // Redirection vers la page principale
                                Intent intent = new Intent(ConnectActivity.this, MainActivity.class );
                                // Export du nom d'utilisateur
                                intent.putExtra("name", name);
                                startActivity(intent);
                            } else {
                                Toast.makeText(ConnectActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }).start();
        }
    }
}