package com.example.aliments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.vues.PanierActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyPanierAdapter  extends BaseAdapter {
    private Context context;
    static private HashMap<Aliment, Double> listeCoursesPanier;
    private LayoutInflater layoutInflater;

    // constructeurs
    public MyPanierAdapter(Context context, HashMap<Aliment, Double> listeCoursesPanier) {
        this.context = context;
        this.listeCoursesPanier = listeCoursesPanier;
        this.layoutInflater = LayoutInflater.from(context);
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
        convertView = this.layoutInflater.inflate(R.layout.listepanier2 , null);

        Aliment currectAliment = (Aliment)getItem(position);
        String name = currectAliment.getName();
        Double quantite = getItemQuantity(position);
        Double prix = currectAliment.getPrix();
        int srcAliment = currectAliment.getRsc();

        convertView.findViewById(R.id.boutonSupprimePanier2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UserControler.get(0).getBasket().getListeProduit2().get(currectAliment) > 1.0)
                {
                    UserControler.get(0).getBasket().getListeProduit2().put(currectAliment, UserControler.get(0).getBasket().getListeProduit2().get(currectAliment) - 1.0);
                }
                else {
                    UserControler.get(0).getBasket().remove(currectAliment);
                    UserControler.get(0).removeListeTotaleDAliment(currectAliment);
                    MyPanierAdapter.remove(currectAliment.getName());
                }
                notifyDataSetChanged();
                PanierActivity.actualiserPrix();
            }
        });

        convertView.findViewById(R.id.boutonAjoutePanier2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserControler.get(0).getBasket().getListeProduit2().put(currectAliment, UserControler.get(0).getBasket().getListeProduit2().get(currectAliment) + 1.0);
                notifyDataSetChanged();
                PanierActivity.actualiserPrix();
            }
        });

        TextView listNameView = convertView.findViewById(R.id.coursePanier2);
        listNameView.setText(name);

        TextView quantiteAliment = convertView.findViewById(R.id.coursePanierQuantite2);
        quantiteAliment.setText("Quantité: "+quantite+" kg");

        TextView prixAliment = convertView.findViewById(R.id.coursePanierPrix2);
        prixAliment.setText("Prix = " + prix + " €");

        ImageView itemIconView = convertView.findViewById(R.id.imageAlimentPanier2);
        itemIconView.setImageResource(srcAliment);

        return convertView;
    }
}
