package com.example.aliments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aliments.vues.AcceuilAcheteurActivity;
import com.example.aliments.vues.AcceuilVendeurActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById( R.id.buttonAcheteur).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AcceuilAcheteurActivity.class);
                startActivity(intent);
            }
        });
        findViewById( R.id.buttonVendeur).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AcceuilVendeurActivity.class);
                startActivity(intent);
            }
        });
    }
}