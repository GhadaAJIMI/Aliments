package com.example.aliments.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aliments.R;
import com.example.aliments.modeles.Aliment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PanierFragmentAdapter extends BaseAdapter {

    private Context context;
    static private HashMap<Aliment, Double> listeCoursesPanier1;
    private LayoutInflater layoutInflater;

    public PanierFragmentAdapter(Context context, HashMap<Aliment, Double> listeCoursesPanier) {
        this.context = context;
        this.listeCoursesPanier1 = listeCoursesPanier;
        this.layoutInflater = LayoutInflater.from(context);
    }



        @Override
    public int getCount() {
        return listeCoursesPanier1.size();
    }

    @Override
    public Object getItem(int position) {
        List<Aliment> liste = new ArrayList(listeCoursesPanier1.keySet());
        return liste.get(position);
    }
    public Double getItemQuantity(int position) {
        List<Double> liste = new ArrayList(listeCoursesPanier1.values());
        return liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.layoutInflater.inflate(R.layout.panierfraglist , null);
        Aliment currentAliment = (Aliment)getItem(position);
        String name = currentAliment.getName();
        Double prix = currentAliment.getPrix();


        TextView listNameView = convertView.findViewById(R.id.nomf);
        listNameView.setText(name);

        TextView prixAliment = convertView.findViewById(R.id.Prix);
        prixAliment.setText("Prix = " + prix + " €");

        return convertView;
    }
}
