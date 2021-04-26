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
import com.example.aliments.modeles.User;
import com.example.aliments.vues.MainActivity;

import java.util.HashMap;

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
        User vendeurB = new User();

        UserControler.listeUsers.add(acheteurA);
        UserControler.listeUsers.add(vendeurB);

        // Remplir la liste des courses preferees de l'acheteurA
        HashMap<String, CoursePreferee> listCoursesPreferees = new HashMap<String, CoursePreferee>();

        ListAliment listeAliment1 = new ListAliment();
        listeAliment1.add(new Aliment("pomme", 500));
        listeAliment1.add(new Aliment("banane", 500));

        listCoursesPreferees.put("Liste1", new CoursePreferee(listeAliment1, "Liste1"));
        listCoursesPreferees.put("Liste2", new CoursePreferee(listeAliment1, "Liste2"));
        listCoursesPreferees.put("Liste3", new CoursePreferee(listeAliment1, "Liste3"));

        ListCoursePreferees listCoursePreferees = new ListCoursePreferees(listCoursesPreferees);

        // ajouter la liste de courses preférées au utilisateurA
        acheteurA.setListeCoursesPreferees(listCoursePreferees);

        // Lancer l'activité principale
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}