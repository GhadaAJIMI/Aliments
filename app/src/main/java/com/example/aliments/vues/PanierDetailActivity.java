package com.example.aliments.vues;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aliments.R;

import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.Basket;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.HashMap;


public class PanierDetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_panier);

        findViewById(R.id.buttonBack2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanierDetailActivity.this, PanierActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.agenda).setOnClickListener(new View.OnClickListener() {
            private String convertWithIteration(HashMap<Aliment, Double> map) {
                String res = "";
                ArrayList<Aliment> arrayList = new ArrayList(map.keySet());
                for(Aliment item : arrayList) res += item.getName()+"\n";
                return res;
            }

            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, "Ma commande chez ALIMENTS");

                HashMap<Aliment, Double> listBasket = UserControler.get(0).getBasket().getListeProduit2();

                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Mon panier contient: \n" + convertWithIteration(listBasket) + "\n" + "J'ai payé " + UserControler.get(0).getBasket().getPrixTotal() + "€" + "\n");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("endTime", cal.getTimeInMillis()+30*60*60*1000);
                intent.putExtra(CalendarContract.Events.ALL_DAY, false);
                startActivity(intent);
                UserControler.get(0).setBasket(new Basket());
            }
        });
    }
}
