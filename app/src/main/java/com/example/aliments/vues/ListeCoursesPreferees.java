package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aliments.R;
import com.example.aliments.modeles.CoursePreferee;

import java.util.ArrayList;
import java.util.List;

public class ListeCoursesPreferees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_courses_preferees);

        List<CoursePreferee> listCoursesPreferees = new ArrayList<>();
    }

    // Ajouter une nouvelle liste de cources preferees

    // supprimer une liste de cources preferees

    // afficher la liste des cources preferees
}