package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.aliments.R;
import com.example.aliments.adapters.AlimentAdapter;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.AlimentFrais;

import java.util.ArrayList;
import java.util.List;

public class ListeAlimentVendeurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_aliment_vendeur);

        List<Aliment> mesAliments = new ArrayList<>(UserControler.get(1).getMagasin().getListeProduits().keySet());

        //get listview

        ListView vendeurListView = findViewById(R.id.vendeur_list_view);
        vendeurListView.setAdapter(new AlimentAdapter(this, mesAliments));

    }
}