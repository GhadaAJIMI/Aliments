package com.example.aliments.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.vues.DetailCoursePreferee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListeCoursesPrefereesAdapter extends BaseAdapter {
    private Context context;
    static private HashMap<String, CoursePreferee> listeCoursesPreferees;
    private LayoutInflater layoutInflater;

    // getters and setters
    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }
    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }
    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }
    public HashMap<String, CoursePreferee> getListeCoursesPreferees() {
        return listeCoursesPreferees;
    }
    public void setListeCoursesPreferees(HashMap<String, CoursePreferee> listeCoursesPreferees) {
        this.listeCoursesPreferees = listeCoursesPreferees;
    }

    // constructeurs
    public ListeCoursesPrefereesAdapter() {
    }
    public ListeCoursesPrefereesAdapter(Context context, HashMap<String, CoursePreferee> listeCoursesPreferees) {
        this.context = context;
        this.listeCoursesPreferees = listeCoursesPreferees;
        this.layoutInflater = LayoutInflater.from(context);
    }

    // méthodes
    static public void remove(CoursePreferee coursesPreferee){
        if(coursesPreferee != null) listeCoursesPreferees.remove(coursesPreferee);
    }

    static public void remove(String nameCoursesPreferee){
        if(nameCoursesPreferee != "") listeCoursesPreferees.remove(nameCoursesPreferee);
    }

    static public void add(CoursePreferee coursesPreferee){
        if(coursesPreferee != null) listeCoursesPreferees.put(coursesPreferee.getName(), coursesPreferee);
    }

    static public void affiche(){
        System.out.println(listeCoursesPreferees);
    }

    @Override
    public int getCount() {
        return listeCoursesPreferees.size();
    }

    @Override
    public CoursePreferee getItem(int position) {
        List<CoursePreferee> liste = new ArrayList<>();

        for (String key : listeCoursesPreferees.keySet()) {
            liste.add(listeCoursesPreferees.get(key));
        }

        return liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.layoutInflater.inflate(R.layout.adapter_liste_courses_preferees , null);

        CoursePreferee currectList = getItem(position);
        String nomListe = currectList.getName();

        TextView listNameView = convertView.findViewById(R.id.nomListeCoursePreferee);
        listNameView.setText(nomListe);

        convertView.findViewById( R.id.boutonSupprime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // supprimer la liste
                ListeCoursesPrefereesAdapter.remove(currectList.getName());
                notifyDataSetChanged();
            }
        });

        convertView.findViewById( R.id.consulterListe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // consulter la liste
                Intent intent = new Intent(context, DetailCoursePreferee.class);
                intent.putExtra("currectList", currectList);
                context.startActivity(intent);
            }
        });

        Button boutonAjout = convertView.findViewById( R.id.boutonAjoute);
        if(AlimentControler.aliment != null){
            boutonAjout.setVisibility(View.VISIBLE);
            boutonAjout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // ajouter l'aliment dans la liste
                    Intent intent = new Intent(context, DetailCoursePreferee.class);
                    intent.putExtra("currectList", currectList);
                    context.startActivity(intent);
                }
            });
        }
        else{
            boutonAjout.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }
}
