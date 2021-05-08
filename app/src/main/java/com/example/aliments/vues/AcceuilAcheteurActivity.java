package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aliments.R;
import com.example.aliments.adapters.FragmentContainer;
import com.example.aliments.adapters.MenuFragment;
import com.example.aliments.adapters.PanierFragment;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.ListAliment;
import com.example.aliments.modeles.Notification;

public class AcceuilAcheteurActivity extends AppCompatActivity {

    FragmentTransaction fragmentPanierTransaction;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_acheteur);

        ListAliment tmp = new ListAliment();
        // Vérifier la liste des aliments modifiés
        for(Aliment aliment2: UserControler.get(0).getTousLesAliments()){
            for(Aliment aliment: AlimentControler.getListeAlimentModifies()){
                if(aliment.equals(aliment2)){

                    // notifier l'utilisateur d'un changement dans le prix
                    if(aliment.getPrix() < aliment2.getPrix()){
                        // on envoie une notification pour tous aliment modifié
                        String titre = "Nouveau Solde pour l'aliment "+aliment.getName();
                        String msg = "Le prix de l'aliment "+aliment.getName()+" est moins chére de " + (aliment2.getPrix()-aliment.getPrix())+" €";
                        new Notification(titre, msg, aliment, AcceuilAcheteurActivity.this, "");
                    }
                    else if(aliment.getPrix() > aliment2.getPrix()){
                        // on envoie une notification pour tous aliment modifié
                        String titre = "Le vendeur a augmenté le prix des "+aliment.getName()+"s";
                        String msg = "Le prix de l'aliment "+aliment.getName()+" est plus chére de " + (aliment.getPrix()-aliment2.getPrix())+" €";
                        new Notification(titre, msg, aliment, AcceuilAcheteurActivity.this, "");
                    }
                    tmp.add(aliment);
                }
            }
        }

        for(Aliment aliment: tmp.getListeAliments()){
            AlimentControler.getListeAlimentModifies2().remove(aliment);
        }

        for(Aliment aliment: tmp.getListeAliments()){
            UserControler.get(0).getTousLesAliments2().get(aliment).setPrix(aliment.getPrix());
        }

        findViewById( R.id.buttonPanier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, PanierActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonParAliment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, SearchAlimentActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonParVendeur).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, SearchSellerActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonListesPreferees).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, ListeCoursesPrefereesActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonPanier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilAcheteurActivity.this, PanierActivity.class);
                startActivity(intent);
            }
        });
        findViewById( R.id.panier1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               fragmentPanierTransaction = getSupportFragmentManager().beginTransaction();
               PanierFragment mF = new PanierFragment();
               fragmentPanierTransaction.replace(R.id.panierfrag , mF);
                fragmentPanierTransaction.commit();
                findViewById( R.id.panier1).setVisibility(View.INVISIBLE);
                findViewById( R.id.panier2).setVisibility(View.VISIBLE);
            }
        });

        findViewById( R.id.panier2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentPanierTransaction = getSupportFragmentManager().beginTransaction();
                FragmentContainer mF = new FragmentContainer();
                fragmentPanierTransaction.replace(R.id.panierfrag , mF);
                fragmentPanierTransaction.commit();
                findViewById( R.id.panier1).setVisibility(View.VISIBLE);
                findViewById( R.id.panier2).setVisibility(View.INVISIBLE);
            }
        });
    }
}