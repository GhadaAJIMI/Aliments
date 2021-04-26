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

        // La liste des aliments
        String[] name = {"Banane" , "Pomme" , "Kiwi", "Orange", "Fraise", "Mango", "Citron", "Cerise" , "Raison rouge","raisin jaune","grenade","pastèque"};
        String [] imgs = {"banane", "pomme" , "kiwi", "orange", "fraise", "mango", "lemon", "cherry" , "grape", "grape1", "grenade", "pasteque"};
        Double prix[] = {5.0, 4.0, 3.0, 2.0, 1.0, 1.0, 1.0, 3.0, 2.0, 3.0, 3.0, 3.0};

        for(int i = 0; i < name.length; i++){
            AlimentControler.getListeAliment().add(new Aliment(name[i], imgs[i], this.getResources().getIdentifier(imgs[i], "drawable", this.getPackageName()), prix[i]));
        }

        // Remplir la liste des courses preferees de l'acheteurA
        HashMap<String, CoursePreferee> listCoursesPreferees = new HashMap<String, CoursePreferee>();

        ListAliment listeAliment1 = new ListAliment();
        listeAliment1.add(AlimentControler.get(1));
        listeAliment1.add(AlimentControler.get(0));
        listeAliment1.add(AlimentControler.get(8));
        listeAliment1.add(AlimentControler.get(9));
        listeAliment1.add(AlimentControler.get(10));

        ListAliment listeAliment2 = new ListAliment();
        listeAliment2.add(AlimentControler.get(1));
        listeAliment2.add(AlimentControler.get(2));
        listeAliment2.add(AlimentControler.get(6));
        listeAliment2.add(AlimentControler.get(7));

        ListAliment listeAliment3 = new ListAliment();
        listeAliment3.add(AlimentControler.get(0));
        listeAliment3.add(AlimentControler.get(1));
        listeAliment3.add(AlimentControler.get(2));
        listeAliment3.add(AlimentControler.get(3));
        listeAliment3.add(AlimentControler.get(4));
        listeAliment3.add(AlimentControler.get(5));

        listCoursesPreferees.put("Liste quotidienne", new CoursePreferee(listeAliment1, "Liste quotidienne"));
        listCoursesPreferees.put("Weekly list", new CoursePreferee(listeAliment2, "Weekly list"));
        listCoursesPreferees.put("Liste de Noel", new CoursePreferee(listeAliment3, "Liste de Noel"));

        // ajouter la liste de courses preférées au utilisateurA
        acheteurA.setListeCoursesPreferees(listCoursesPreferees);

        // initialiser le magasin du vendeurB
        HashMap<Aliment, Double> listeProduits = new HashMap<>();
        listeProduits.put(AlimentControler.get(0), 300.0);
        listeProduits.put(AlimentControler.get(1), 100.0);
        listeProduits.put(AlimentControler.get(2), 50.0);
        listeProduits.put(AlimentControler.get(3), 50.0);
        listeProduits.put(AlimentControler.get(4), 50.0);
        listeProduits.put(AlimentControler.get(5), 50.0);
        listeProduits.put(AlimentControler.get(6), 50.0);

        Magasin magasin = new Magasin();
        magasin.setListeProduits(listeProduits);
        magasin.setProprio(vendeurB);
        vendeurB.setMagasin(magasin);

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