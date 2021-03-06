package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket implements Parcelable {
    private HashMap<Aliment, Double> listeProduit = new HashMap<Aliment, Double>();
    private double prixTotal;

    public Basket(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
    @Override
    public int describeContents() { return 0;}

    public static final Creator<Basket> CREATOR = new Creator<Basket>() {
        @Override
        public Basket createFromParcel(Parcel in) {
            return new Basket(in);
        }

        @Override
        public Basket[] newArray(int size) {
            return new Basket[size];
        }
    };

    // getters and setters
    public List<Aliment> getListeProduit() {
        return new ArrayList<>(listeProduit.keySet());
    }
    public HashMap<Aliment, Double> getListeProduit2() {
        return listeProduit;
    }
    public void setListeProduit(HashMap<Aliment, Double> listeProduit) {
        this.listeProduit = listeProduit;
    }

    // constructeur
    public Basket() {
        listeProduit = new HashMap<Aliment, Double>();
        this.prixTotal = 0;
    }

    public Basket(HashMap<Aliment, Double> listeProduit, double prixTotal) {
        this.listeProduit = listeProduit;
        this.prixTotal = prixTotal ;
    }

    // méthodes
    public void add(Aliment aliment){
        listeProduit.put(aliment, 1.0);
    }

    public void add(Aliment aliment, Double i){
        if(find(aliment.getId()) != null)
            listeProduit.put(find(aliment.getId()), listeProduit.get(find(aliment.getId())) + i);
        else
            listeProduit.put(aliment, 1.0);
    }

    public Aliment get(int i){
        List<Aliment> liste = new ArrayList(listeProduit.keySet());
        return liste.get(i);
    }

    public Boolean contains(Aliment aliment){
        return listeProduit.containsKey(aliment);
    }

    public Boolean contains(String name){
        for(Aliment aliment: listeProduit.keySet()){
            if(aliment.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public Aliment find(int id){
        for(Aliment aliment: listeProduit.keySet()){
            if(aliment.getId() == id)
                return aliment;
        }
        return null;
    }

    public void put(Aliment aliment, Double i){
        listeProduit.put(aliment, i);
    }

    public void remove(int id){
        listeProduit.remove(find(id));
    }
    public void remove(Aliment aliment){
        listeProduit.remove(find(aliment.getId()));
    }

    public double getPrixTotal(){
        double total = 0.0;
        for (Map.Entry aliment : listeProduit.entrySet()) {
            total = total + ((Aliment) aliment.getKey()).getPrix() * ((double)aliment.getValue());
        }
        return total;
    }
}
