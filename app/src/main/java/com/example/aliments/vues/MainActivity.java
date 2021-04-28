package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.aliments.R;
import com.example.aliments.adapters.FragmentContainer;
import com.example.aliments.adapters.MenuFragment;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.User;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;

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

        findViewById( R.id.image1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                MenuFragment mF = new MenuFragment();
                fragmentTransaction.replace(R.id.fragment , mF);
                fragmentTransaction.commit();
                findViewById( R.id.buttonAcheteur).setVisibility(View.INVISIBLE);
                findViewById( R.id.buttonVendeur).setVisibility(View.INVISIBLE);
                findViewById( R.id.image1).setVisibility(View.INVISIBLE);
                findViewById( R.id.image2).setVisibility(View.VISIBLE);
            }
        });

        findViewById( R.id.image2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                FragmentContainer mF = new FragmentContainer();
                fragmentTransaction.replace(R.id.fragment , mF);
                fragmentTransaction.commit();
                findViewById( R.id.buttonAcheteur).setVisibility(View.VISIBLE);
                findViewById( R.id.buttonVendeur).setVisibility(View.VISIBLE);
                findViewById( R.id.image1).setVisibility(View.VISIBLE);
                findViewById( R.id.image2).setVisibility(View.INVISIBLE);
            }
        });
    }
}