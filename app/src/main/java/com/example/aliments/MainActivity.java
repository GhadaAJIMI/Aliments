package com.example.aliments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aliments.vues.Acceuil;
import com.example.aliments.vues.AcceuilAchteur;
import com.example.aliments.vues.NotificationsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById( R.id.buttonAcheteur).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AcceuilAchteur.class);
                startActivity(intent);
            }
        });
    }
}