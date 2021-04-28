package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.Notification;

public class CreerUneListeCoursePreferee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_une_liste_course_preferee);

        EditText name = findViewById(R.id.nameListe);

        findViewById( R.id.valider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameListe = name.getText().toString();
                if(!nameListe.trim().equals("") && !UserControler.get(0).getListeCoursesPreferees().containsKey(nameListe)){
                    UserControler.get(0).getListeCoursesPreferees2().add(new CoursePreferee(nameListe));

                    String titre = "Nouvelle liste de course préféré";
                    String msg = "Vous avez créé la liste " + nameListe;
                    new Notification(titre, msg, R.drawable.shopping_cart, CreerUneListeCoursePreferee.this, Notification.SIMPLE);
                    Toast.makeText(CreerUneListeCoursePreferee.this, "Vous avez créé la liste " + nameListe, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CreerUneListeCoursePreferee.this, ListeCoursesPrefereesActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(CreerUneListeCoursePreferee.this, "Veuillez choisir un nom valide et unique", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById( R.id.boutonRetouner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreerUneListeCoursePreferee.this, ListeCoursesPrefereesActivity.class);
                startActivity(intent);
            }
        });
    }
}