package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aliments.R;
import com.example.aliments.adapters.ListeMagasinsAdapter;
import com.example.aliments.adapters.MyPanierAdapter;
import com.example.aliments.adapters.PanierAdapter;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.MagasinControler;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.Basket;
import com.example.aliments.modeles.CoursePreferee;

public class PanierActivity extends AppCompatActivity {

    TextView monPanier;
    Button addEvent;

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
        panierListView.setAdapter(new MyPanierAdapter(this, UserControler.get(0).getBasket().getListeProduit()));

        //TextView prixTotal = findViewById(R.id.prixTotal);
        //prixTotal.setText(new MyPanierAdapter(this, UserControler.get(0).getBasket().getPrixTotal()));
        monPanier = findViewById(R.id.panierList);

        addEvent = findViewById(R.id.agenda);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, monPanier.getText().toString());
               // intent.putExtra(CalendarContract.Events.DESCRIPTION, (Parcelable) panierListView);
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                startActivity(intent);
            }
        });
    }
}