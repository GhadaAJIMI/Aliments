package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Magasin implements Parcelable {
    private User proprio;
    private HashMap<Aliment, Double> listeProduits;
    private String name;
    private String numeroTelephone;
    private String mnemonic;

    protected Magasin(Parcel in) {
        proprio = in.readParcelable(User.class.getClassLoader());
        name = in.readString();
        numeroTelephone = in.readString();
        mnemonic = in.readString();
    }

    public static final Creator<Magasin> CREATOR = new Creator<Magasin>() {
        @Override
        public Magasin createFromParcel(Parcel in) {
            return new Magasin(in);
        }

        @Override
        public Magasin[] newArray(int size) {
            return new Magasin[size];
        }
    };

    // getters and setters
    public User getProprio() {
        return proprio;
    }
    public void setProprio(User proprio) {
        this.proprio = proprio;
    }
    public HashMap<Aliment, Double> getListeProduits() {
        return listeProduits;
    }
    public void setListeProduits(HashMap<Aliment, Double> listeProduits) {
        this.listeProduits = listeProduits;
    }
    public String getNumeroTelephone() { return numeroTelephone; }
    public String getName() { return name; }
    public String getMnemonic() { return mnemonic; }

    // constructeurs
    public Magasin() {
        proprio = null;
        listeProduits = new HashMap<Aliment, Double>();
        name = "";
        numeroTelephone = "";
        mnemonic = "";
    }

    public Magasin(String name, String mnemonic, String numeroTelephone ){
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

    public Aliment getAliment(int i){
        List<Aliment> listeTmp = new ArrayList<>(listeProduits.keySet());
        return listeTmp.get(i);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(numeroTelephone);
        dest.writeString(mnemonic);
    }
}
