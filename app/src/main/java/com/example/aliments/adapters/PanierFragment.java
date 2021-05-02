package com.example.aliments.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.aliments.R;
import com.example.aliments.controleurs.UserControler;

public class PanierFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.panier_fragment , container , false);
        ListView listPanier = v.findViewById(R.id.ListePanier);
        listPanier.setAdapter(new PanierFragmentAdapter(v.getContext() , UserControler.get(0).getBasket().getListeProduit2()));
        return v;
    }
}
