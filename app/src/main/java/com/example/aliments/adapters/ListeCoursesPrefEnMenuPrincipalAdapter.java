package com.example.aliments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.aliments.R;
import com.example.aliments.modeles.CoursePreferee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListeCoursesPrefEnMenuPrincipalAdapter  extends BaseAdapter {
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
    public ListeCoursesPrefEnMenuPrincipalAdapter() {
    }
    public ListeCoursesPrefEnMenuPrincipalAdapter(Context context, HashMap<String, CoursePreferee> listeCoursesPreferees) {
        this.context = context;
        this.listeCoursesPreferees = listeCoursesPreferees;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listeCoursesPreferees.size();
    }

    @Override
    public Object getItem(int position) {
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
        convertView = this.layoutInflater.inflate(R.layout.listcoursespref , null);

        CoursePreferee currectList = (CoursePreferee)getItem(position);
        String nomListe = currectList.getName();

        TextView listNameView = convertView.findViewById(R.id.coursePref);
        listNameView.setText(nomListe);

        return convertView;
    }
}
