package com.example.aliments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.aliments.R;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.ListAliment;
import java.util.List;

public class ListeAlimentsAdapter extends BaseAdapter {
    private Context context;
    static private ListAliment listeAliments;
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
    public static ListAliment getListeAliments() {
        return listeAliments;
    }
    public static void setListeAliments(ListAliment listeAliments) {
        ListeAlimentsAdapter.listeAliments = listeAliments;
    }

    // constructeurs
    public ListeAlimentsAdapter() {
    }

    public ListeAlimentsAdapter(Context context, ListAliment listeAliment) {
        this.context = context;
        this.listeAliments = listeAliment;
        this.layoutInflater = LayoutInflater.from(context);
    }

    // méthodes
    static public void remove(String nameAliment){
        listeAliments.getListeAliments().remove(nameAliment);
    }

    @Override
    public int getCount() {
        return listeAliments.getListeAliments().size();
    }

    @Override
    public Aliment getItem(int position) {
        return listeAliments.getListeAliments().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.layoutInflater.inflate(R.layout.adapter_liste_aliment , null);

        Aliment currectList = getItem(position);
        String nameAliment = currectList.getName();
        String memicAliment = currectList.getMnemonic();
        double priceAliment = currectList.getPrix();
        int srcAliment = currectList.getRsc();

        TextView nomAliment = convertView.findViewById(R.id.nomAliment);
        nomAliment.setText(nameAliment);

        TextView prixAliment = convertView.findViewById(R.id.prixAliment);
        prixAliment.setText("Prix = " + priceAliment + " €");

        ImageView itemIconView = convertView.findViewById(R.id.imageAliment);
        itemIconView.setImageResource(srcAliment);

        return convertView;
    }
}
