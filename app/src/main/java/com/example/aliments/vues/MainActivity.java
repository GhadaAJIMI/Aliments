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
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch sw = findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
             if(isChecked){
                 fragmentTransaction = getSupportFragmentManager().beginTransaction();
                 MenuFragment mF = new MenuFragment();
                 fragmentTransaction.replace(R.id.fragment , mF);
                 fragmentTransaction.commit();
             }else{
                 fragmentTransaction = getSupportFragmentManager().beginTransaction();
                 FragmentContainer mF = new FragmentContainer();
                 fragmentTransaction.replace(R.id.fragment , mF);
                 fragmentTransaction.commit();
             }
            }
        });
    }
}