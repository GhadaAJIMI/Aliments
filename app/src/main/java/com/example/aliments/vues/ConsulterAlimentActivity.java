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
    int id;

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

        id = AlimentControler.aliment.getId();

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
                String nameAliment = name.getText().toString();
                UserControler.get(0).getBasket().add(AlimentControler.get(id));
                UserControler.get(0).getTousLesAliments().add(AlimentControler.get(id));
                Toast.makeText(ConsulterAlimentActivity.this, "Vous avez ajouter 1kg de " + nameAliment + " dans le panier", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById( R.id.ajout1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlimentControler.aliment = AlimentControler.get(id);
                Intent intent = new Intent(ConsulterAlimentActivity.this, ListeCoursesPrefereesActivity.class);
                startActivity(intent);
            }
        });
    }
}