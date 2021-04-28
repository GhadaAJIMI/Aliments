package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.Notification;

import java.util.Objects;

public class DetailAliment extends AppCompatActivity {
    public static final String CHANNEL_1_ID = "channel LOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_aliment);

        TextView editName = findViewById(R.id.aliment_name2);
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

                // tester si le prix a changé
                double prix = Double.valueOf(editPrix.getText().toString()).doubleValue();
                if(AlimentControler.getListeAliment().get(name).getPrix() != prix){
                    AlimentControler.getListeAliment().get(name).setPrix(prix);
                    AlimentControler.addListeAlimentModifies(new Aliment(AlimentControler.aliment));
                }

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