package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aliments.MainActivity;
import com.example.aliments.R;

public class AcceuilAcheteurActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_acheteur);

        findViewById( R.id.buttonBack1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonParAliment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, SearchByAlimentActivity.class);
                startActivity(intent);
            }
        });
    }
}