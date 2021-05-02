package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.adapters.ListeMagasinsAdapter;
import com.example.aliments.adapters.MyPanierAdapter;
import com.example.aliments.adapters.PanierAdapter;
import com.example.aliments.controleurs.MagasinControler;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

        GridView panierListView = findViewById(R.id.p_list_view);
        panierListView.setAdapter(new MyPanierAdapter(this, UserControler.get(0).getBasket().getListeProduit2()));

        TextView prixTotal = findViewById(R.id.prixTotal);
        prixTotal.setText("Prix Total = " + (double) UserControler.get(0).getBasket().getPrixTotal() + "€");

       findViewById(R.id.valider).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent( PanierActivity.this, PanierDetailActivity.class);
               startActivity(intent);
               Toast.makeText(PanierActivity.this, " Le panier est validé", Toast.LENGTH_SHORT).show();
           }
       });


    }
}