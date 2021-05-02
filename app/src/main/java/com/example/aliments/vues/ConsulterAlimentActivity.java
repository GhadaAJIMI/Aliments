package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.UserControler;

public class ConsulterAlimentActivity extends AppCompatActivity {

    String tx;String tx1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_aliment);

        ImageView imageView = findViewById(R.id.aliment_icon);
        TextView name = findViewById(R.id.aliment_name2);
        TextView price = findViewById(R.id.aliment_price2);

        imageView.setImageResource(AlimentControler.aliment.getRsc());
        name.setText(AlimentControler.aliment.getName());
        price.setText(AlimentControler.aliment.getPrix()+" €");

        AlimentControler.aliment = null;

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsulterAlimentActivity.this, SearchAlimentActivity.class);
                startActivity(intent);
            }
        });


        findViewById( R.id.ajoutPanier1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx = name.getText().toString();
                UserControler.get(0).getBasket().add(AlimentControler.get(tx));
                UserControler.get(0).getTousLesAliments().add(AlimentControler.get(tx));
                Toast.makeText(ConsulterAlimentActivity.this, "Vous avez ajouter 1kg de " + tx + " dans le panier", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById( R.id.ajout1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 tx1 = name.getText().toString();
                AlimentControler.aliment = AlimentControler.get(tx1);
                Intent intent = new Intent(ConsulterAlimentActivity.this, ListeCoursesPrefereesActivity.class);
                startActivity(intent);
            }
        });


    }
}