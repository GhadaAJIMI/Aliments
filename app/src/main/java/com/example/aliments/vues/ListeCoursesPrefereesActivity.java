package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.aliments.R;
import com.example.aliments.adapters.ListeCoursesPrefereesAdapter;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.ListAliment;

import java.util.HashMap;

public class ListeCoursesPrefereesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_courses_preferees);

        ListView listCourse = findViewById(R.id.listeCourse);
        listCourse.setAdapter(new ListeCoursesPrefereesAdapter(this, UserControler.get(0).getListeCoursesPreferees()));
        
        findViewById( R.id.boutonRetouner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListeCoursesPrefereesActivity.this, AcceuilAcheteurActivity.class);
                startActivity(intent);
            }
        });
    }
}