package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import com.example.aliments.R;
import com.example.aliments.adapters.ListeAlimentsAdapter;
import com.example.aliments.modeles.CoursePreferee;

public class DetailCoursePreferee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_course_preferee);

        Intent intent = getIntent();
        CoursePreferee currectList = intent.getParcelableExtra("currectList");

        TextView nomListe = findViewById(R.id.nameListe);
        nomListe.setText(currectList.getName());

        // Récupérer la liste des aliments et les afficher
        GridView listeAliments = findViewById(R.id.listeAliments);
        listeAliments.setAdapter(new ListeAlimentsAdapter(this, currectList.getListeAliment()));

        findViewById( R.id.boutonRetouner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCoursePreferee.this, ListeCoursesPrefereesActivity.class);
                startActivity(intent);
            }
        });
    }
}