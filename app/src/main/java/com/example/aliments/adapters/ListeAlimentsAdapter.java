package com.example.aliments.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.ListAliment;
import com.example.aliments.vues.DetailCoursePreferee;
import com.example.aliments.vues.ListeCoursesPrefereesActivity;
import com.example.aliments.vues.PanierActivity;

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

        Aliment currentAliment = getItem(position);
        String nameAliment = currentAliment.getName();
        String memicAliment = currentAliment.getMnemonic();
        double priceAliment = currentAliment.getPrix();
        int srcAliment = currentAliment.getRsc();

        TextView nomAliment = convertView.findViewById(R.id.nomAliment);
        nomAliment.setText(nameAliment);

        TextView prixAliment = convertView.findViewById(R.id.prixAliment);
        prixAliment.setText("Prix = " + priceAliment + " €");

        ImageView itemIconView = convertView.findViewById(R.id.imageAliment);
        itemIconView.setImageResource(srcAliment);

        convertView.findViewById(R.id.supprimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titre = UserControler.get(0).currentList.getName();
                CoursePreferee coursePreferee = UserControler.get(0).getListeCoursesPreferees().get(titre);
                coursePreferee.remove(currentAliment.getId());
                listeAliments.remove(currentAliment);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
