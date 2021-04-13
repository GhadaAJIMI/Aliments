package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;


public class Magasin {
    private Seller proprio;
    private HashMap<Aliment, Double> listeProduits;
    private int numeroTelephone;

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
    public void setNumeroTelephone(int numeroTelephone) {this.numeroTelephone = numeroTelephone; }

    // constructeurs
    public Magasin() {super();}

    public Magasin(Seller proprio, HashMap<Aliment, Double> listeProduits, int numeroTelephone) {
        this.proprio = proprio;
        this.listeProduits = listeProduits;
        this.numeroTelephone = getNumeroTelephone();
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
}
