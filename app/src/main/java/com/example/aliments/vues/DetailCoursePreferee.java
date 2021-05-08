package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.adapters.ListeAlimentsAdapter;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.CoursePreferee;

public class DetailCoursePreferee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_course_preferee);

        Intent intent = getIntent();
        CoursePreferee currectList = intent.getParcelableExtra("currectList");
        UserControler.get(0).currentList = currectList;

        if(AlimentControler.aliment != null && !currectList.contains(AlimentControler.aliment)){
            currectList.getListeAliment().add(AlimentControler.aliment);
            UserControler.get(0).getListeCoursesPreferees().get(currectList.getName()).add(AlimentControler.aliment);
            UserControler.get(0).getTousLesAliments().add(new Aliment(AlimentControler.aliment));
            Toast.makeText(DetailCoursePreferee.this, "Vous avez ajouter le " + AlimentControler.aliment.getName() + " dans la liste '"+currectList.getName()+"'", Toast.LENGTH_SHORT).show();
            AlimentControler.aliment = null;
        }
        else if(AlimentControler.aliment != null && currectList.contains(AlimentControler.aliment)){
            Toast.makeText(DetailCoursePreferee.this, "Cet aliment existe déjà dans la liste", Toast.LENGTH_SHORT).show();
            AlimentControler.aliment = null;
        }
        else{
            AlimentControler.aliment = null;
        }

        TextView nomListe = findViewById(R.id.nameListe);
        nomListe.setText(currectList.getName());

        // Récupérer la liste des aliments et les afficher
        GridView listeAliments = findViewById(R.id.listeAliments);
        listeAliments.setAdapter(new ListeAlimentsAdapter(this, currectList.getListeAliment2()));

        findViewById( R.id.boutonRetouner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCoursePreferee.this, ListeCoursesPrefereesActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.ajouter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailCoursePreferee.this, SearchAlimentActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.boutonAjoutPanier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currectList.getListeAliment().size() > 0){
                    // ajouter tous les aliments dans le panier
                    for(Aliment aliment: currectList.getListeAliment()){
                        UserControler.get(0).getBasket().add(aliment, 1.0);
                    }

                    Intent intent = new Intent(DetailCoursePreferee.this, PanierActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(DetailCoursePreferee.this, "Votre liste est vide", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}