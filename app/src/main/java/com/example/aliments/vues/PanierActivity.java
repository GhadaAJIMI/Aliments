package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.aliments.R;
import com.example.aliments.adapters.ListeMagasinsAdapter;
import com.example.aliments.adapters.PanierAdapter;
import com.example.aliments.controleurs.MagasinControler;
import com.example.aliments.controleurs.UserControler;

public class PanierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanierActivity.this, AcceuilAcheteurActivity.class);
                startActivity(intent);
            }
        });

        ListView panierListView = findViewById(R.id.p_list_view);
        panierListView.setAdapter(new PanierAdapter(this, UserControler.get(0).getBasket().getListeProduit()));
    }
}