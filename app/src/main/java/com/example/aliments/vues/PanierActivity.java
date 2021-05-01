package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
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
        panierListView.setAdapter(new MyPanierAdapter(this, UserControler.get(0).getBasket().getListeProduit2()));

        //TextView prixTotal = findViewById(R.id.prixTotal);
        //prixTotal.setText(new MyPanierAdapter(this, UserControler.get(0).getBasket().getPrixTotal()));
        monPanier = findViewById(R.id.panierList);

        addEvent = findViewById(R.id.agenda);
        addEvent.setOnClickListener(new View.OnClickListener() {

            private String convertWithIteration(HashMap<Aliment, Double> map) {
                String res = "";

                ArrayList<Aliment> arrayList = new ArrayList(map.keySet());
                for(Aliment item : arrayList) res += item.getName()+"\n";
                return res;
            }


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, monPanier.getText().toString());

                HashMap<Aliment, Double> listBasket = UserControler.get(0).getBasket().getListeProduit2();

                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Mon panier contient: \n" + convertWithIteration(listBasket) );
                intent.putExtra(CalendarContract.Events.DTSTART, Calendar.getInstance().getTimeInMillis());
                intent.putExtra(CalendarContract.Events.DTEND, Calendar.getInstance().getTimeInMillis() +48*60*60*1000);
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                startActivity(intent);

                Toast.makeText(PanierActivity.this, " Le panier est validé", Toast.LENGTH_SHORT).show();

            }

        });


    }
}