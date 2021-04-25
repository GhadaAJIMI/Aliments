package com.example.aliments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.User;
import com.example.aliments.vues.AcceuilAcheteurActivity;
import com.example.aliments.vues.MainActivity;

public class Lancement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancement);

        UserControler userControl = new UserControler();

        // initialisation des utilisateurs
        User acheteurA = new User();
        User vendeurB = new User();

        UserControler.listeUsers.add(acheteurA);
        UserControler.listeUsers.add(vendeurB);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}