package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Magasin {
    private Seller proprio;
    private HashMap<Aliment, Double> listeProduits;
    private String name;
    private int numeroTelephone;
    private String mnemonic;

    public Magasin(Parcel in) {
        //listeProduits = in.readHashMap();
        numeroTelephone = in.readInt();
    }

    // getters and setters
    public Seller getProprio() {
        return proprio;
    }
    public void setProprio(Seller proprio) {
        this.proprio = proprio;
    }
    public HashMap<Aliment, Double> getListeProduits() {
        return listeProduits;
    }
    public void setListeProduits(HashMap<Aliment, Double> listeProduits) {
        this.listeProduits = listeProduits;
    }
    public int getNumeroTelephone() { return numeroTelephone; }
    public String getName() { return name; }
    public String getMnemonic() { return mnemonic; }

    // constructeurs
    public Magasin() {super();}

    public Magasin(Seller proprio, HashMap<Aliment, Double> listeProduits) {
        this.proprio = proprio;
        this.listeProduits = listeProduits;
    }

    public Magasin(String name, String mnemonic, int numeroTelephone ){
        this.name = name;
        this.numeroTelephone = numeroTelephone;
        this.mnemonic = mnemonic;
    }

    // méthodes
    public void ajouterAliment(String name, double price, String imageMemic, double quantite, int type) throws Throwable{
        Aliment aliment = AlimentFactory.build(type);
        aliment.setPrix(price);
        aliment.setName(name);

        listeProduits.put(aliment, quantite);
    }

    public void ajouterAliment(String name, double price, double quantite, int type) throws Throwable{
        Aliment aliment = AlimentFactory.build(type);
        aliment.setPrix(price);
        aliment.setName(name);

        listeProduits.put(aliment, quantite);
    }
    public static final Parcelable.Creator<Magasin> CREATOR = new Parcelable.Creator<Magasin>() {
        @Override
        public Magasin createFromParcel(Parcel in) {
            return new Magasin(in);
        }

        @Override
        public Magasin[] newArray(int size) {
            return new Magasin[size];
        }
    };

    public Aliment getAliment(int i){
        List<Aliment> listeTmp = new ArrayList<>(listeProduits.keySet());
        return listeTmp.get(i);
    }
}
