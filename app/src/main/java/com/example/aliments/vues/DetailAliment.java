package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;

public class DetailAliment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_aliment);

        EditText editName = findViewById(R.id.aliment_name2);
        editName.setText(AlimentControler.aliment.getName());

        EditText editPrix = findViewById(R.id.aliment_price2);
        editPrix.setText(AlimentControler.aliment.getPrix() + "");

        ImageView img = findViewById(R.id.aliment_icon);
        img.setImageResource(AlimentControler.aliment.getRsc());

        Button btnModif = findViewById(R.id.valider);
        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailAliment.this, ListeAlimentVendeurActivity.class);
                String name = editName.getText().toString();
                AlimentControler.getListeAliment().get(AlimentControler.aliment.getName()).setName(name);
                AlimentControler.getListeAliment().get(name).setPrix(Double.valueOf(editPrix.getText().toString()).doubleValue());
                // notifier l'utilisateur d'un changement dans le prix
                AlimentControler.aliment = null;
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailAliment.this, ListeAlimentVendeurActivity.class);
                AlimentControler.aliment = null;
                startActivity(intent);
            }
        });

    }
}