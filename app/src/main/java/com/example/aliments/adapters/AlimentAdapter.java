package com.example.aliments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.vues.ListeAlimentVendeurActivity;

import java.util.List;

public class AlimentAdapter extends BaseAdapter {

    //attributs
    private Context context;
    private List<Aliment> alimentList;
    private LayoutInflater inflater;

    //constructeur
    public AlimentAdapter(Context context, List<Aliment> alimentList){
        this.context = context;
        this.alimentList = alimentList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return alimentList.size();
    }

    @Override
    public Aliment getItem(int position) {
        return alimentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_aliment_vendeur, null);

        Aliment currentAliment = getItem(position);
        String name = currentAliment.getName();
        double prix = currentAliment.getPrix();
        String mnemonic = currentAliment.getMnemonic();

        TextView itemNameView = view.findViewById(R.id.aliment_name);
        itemNameView.setText(name);

        TextView itemPrixView = view.findViewById(R.id.aliment_price);
        itemPrixView.setText(prix+"€");

        ImageView itemIconView = view.findViewById(R.id.aliment_icon);
        int resId = context.getResources().getIdentifier(mnemonic, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(context, "Vous avez proposé à la la vente un "+name+" pour "+prix+"€", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
