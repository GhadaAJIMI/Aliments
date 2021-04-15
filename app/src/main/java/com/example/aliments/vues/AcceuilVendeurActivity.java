package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aliments.MainActivity;
import com.example.aliments.R;

public class AcceuilVendeurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_vendeur);

        findViewById( R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilVendeurActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonListeDesArticle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilVendeurActivity.this, ListeAlimentVendeurActivity.class);
                startActivity(intent);
            }
        });
    }
}