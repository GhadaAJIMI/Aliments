package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.aliments.R;
import com.example.aliments.adapters.ListeCoursesPrefereesAdapter;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.ListAliment;

import java.util.HashMap;

public class ListeCoursesPrefereesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_courses_preferees);

        HashMap<String, CoursePreferee> listCourcesPreferees = new HashMap<String, CoursePreferee>();

        ListAliment listeAliment1 = new ListAliment();
        listeAliment1.add(new Aliment("pomme", 500));
        listeAliment1.add(new Aliment("banane", 500));

        listCourcesPreferees.put("Liste1", new CoursePreferee(listeAliment1, "Liste1"));
        listCourcesPreferees.put("Liste2", new CoursePreferee(listeAliment1, "Liste2"));
        listCourcesPreferees.put("Liste3", new CoursePreferee(listeAliment1, "Liste3"));

        ListView listCourse = findViewById(R.id.listeCourse);
        listCourse.setAdapter(new ListeCoursesPrefereesAdapter(this, listCourcesPreferees));
        
        findViewById( R.id.boutonRetouner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListeCoursesPrefereesActivity.this, AcceuilAcheteurActivity.class);
                startActivity(intent);
            }
        });
    }
}