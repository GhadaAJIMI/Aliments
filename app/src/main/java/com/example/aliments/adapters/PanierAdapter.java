
package com.example.aliments.adapters;


import android.content.Context;
import android.content.Intent;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.aliments.R;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.Basket;
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.vues.PanierActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PanierAdapter extends BaseAdapter {
    private double prixTotal = 0;
    private Context context;
    static private HashMap<Aliment, Double> listeCoursesPanier;
    private LayoutInflater layoutInflater;

    public PanierAdapter(Context context, double prixTotal) {
        this.context = context;
        this.prixTotal = prixTotal;
    }

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
    public HashMap<Aliment, Double> getListeCoursesPanier() {
        return listeCoursesPanier;
    }
    public void setListeCoursesPanier(HashMap<Aliment, Double> listeCoursesPanier) {
        this.listeCoursesPanier = listeCoursesPanier;
    }

    // constructeurs
    public PanierAdapter() {
    }
    public PanierAdapter(Context context, HashMap<Aliment, Double> listeCoursesPanier) {
        this.context = context;
        this.listeCoursesPanier = listeCoursesPanier;
        this.layoutInflater = LayoutInflater.from(context);
    }

    // méthodes
    static public void remove(String nameCoursesPanier){
        if(nameCoursesPanier != "") listeCoursesPanier.remove(nameCoursesPanier);
    }

    @Override
    public int getCount() {
        return listeCoursesPanier.size();
    }

    @Override
    public Object getItem(int position) {
        List<Aliment> liste = new ArrayList(listeCoursesPanier.keySet());
        return liste.get(position);
    }

    public Double getItemQuantity(int position) {
        List<Double> liste = new ArrayList(listeCoursesPanier.values());
        return liste.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.layoutInflater.inflate(R.layout.listepanier , null);

        Aliment currectAliment = (Aliment)getItem(position);
        String name = currectAliment.getName();
        Double quantite = getItemQuantity(position);
        Double prix = currectAliment.getPrix();
        int srcAliment = currectAliment.getRsc();

        TextView listNameView = convertView.findViewById(R.id.coursePanier);
        listNameView.setText(name);

        TextView quantiteAliment = convertView.findViewById(R.id.coursePanierQuantite);
        quantiteAliment.setText("Q: "+quantite+" kg");

       TextView prixAliment = convertView.findViewById(R.id.coursePanierPrix);
        prixAliment.setText("Prix = " + prix + " €");

        ImageView itemIconView = convertView.findViewById(R.id.imageAlimentPanier);
        itemIconView.setImageResource(srcAliment);

        return convertView;
    }
}


