package com.example.aliments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.MagasinControler;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.ListAliment;
import com.example.aliments.modeles.ListCoursePreferees;
import com.example.aliments.modeles.Magasin;
import com.example.aliments.modeles.User;
import com.example.aliments.vues.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lancement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancement);

        // initialisation des contrôleurs
        AlimentControler alimentControler = new AlimentControler();
        MagasinControler magasinControler = new MagasinControler();
        UserControler userControl = new UserControler();

        // initialisation des utilisateurs
        User acheteurA = new User();
        acheteurA.setName("Ghada");

        User vendeurB = new User();
        vendeurB.setName("Floriane");

        // Remplir la liste des courses preferees de l'acheteurA
        HashMap<String, CoursePreferee> listCoursesPreferees = new HashMap<String, CoursePreferee>();

        ListAliment listeAliment1 = new ListAliment();
        listeAliment1.add(new Aliment("pomme", 3));
        listeAliment1.add(new Aliment("banane", 4));

        listCoursesPreferees.put("Liste1", new CoursePreferee(listeAliment1, "Liste1"));
        listCoursesPreferees.put("Liste2", new CoursePreferee(listeAliment1, "Liste2"));
        listCoursesPreferees.put("Liste3", new CoursePreferee(listeAliment1, "Liste3"));

        // ajouter la liste de courses preférées au utilisateurA
        acheteurA.setListeCoursesPreferees(listCoursesPreferees);

        // initialiser le magasin du vendeurB
        HashMap<Aliment, Double> listeProduits = new HashMap<>();
        listeProduits.put(new Aliment("Orange", "orange", 2), 300.0);
        listeProduits.put(new Aliment("Banane","banane", 4), 100.0);
        listeProduits.put(new Aliment("Fraise","fraise", 10), 50.0);

        Magasin magasin = new Magasin();
        magasin.setListeProduits(listeProduits);
        magasin.setProprio(vendeurB);

        // initialiser les valeurs du contrôleur MagasinControler
        MagasinControler.add(new Magasin("SHOP1", "1", 0600000000));
        MagasinControler.add(new Magasin("SHOP2", "2", 0611111111));
        MagasinControler.add(new Magasin("SHOP3", "3", 0622222222));
        MagasinControler.add(magasin);

        // initialiser les valeurs du contrôleur UserControler
        UserControler.listeUsers.add(acheteurA);
        UserControler.listeUsers.add(vendeurB);

        // Lancer l'activité principale
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}