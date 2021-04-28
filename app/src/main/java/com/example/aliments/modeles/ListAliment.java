package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ListAliment implements Parcelable {
    private List<Aliment> listeAliments;
    private double prixTotal;

    public ListAliment(Parcel in) {
        listeAliments = in.createTypedArrayList(Aliment.CREATOR);
        prixTotal = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(listeAliments);
        dest.writeDouble(prixTotal);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListAliment> CREATOR = new Creator<ListAliment>() {
        @Override
        public ListAliment createFromParcel(Parcel in) {
            return new ListAliment(in);
        }

        @Override
        public ListAliment[] newArray(int size) {
            return new ListAliment[size];
        }
    };

    public List<Aliment> getListeAliments() {
        return listeAliments;
    }
    public void setListeAliments(List<Aliment> listeAliments) {
        this.listeAliments = listeAliments;
    }
    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    // constructeur
    public ListAliment() {
        this.listeAliments = new ArrayList<Aliment>();
        prixTotal = 0;
    }

    public ListAliment(List<Aliment> listeAliments) {
        this.listeAliments = listeAliments;
        this.prixTotal = getPrixTotal();
    }

    // méthodes
    public double getPrixTotal(){
        double prixTotal = 0;
        for(Aliment aliment: listeAliments){
            prixTotal += aliment.getPrix();
        }
        this.prixTotal = prixTotal;
        return prixTotal;
    }

    public void add(Aliment aliment){
        listeAliments.add(aliment);
        this.prixTotal += aliment.getPrix();
    }

    public void remove(Aliment aliment){
        listeAliments.remove(aliment);
        this.prixTotal -= aliment.getPrix();
    }

    public Aliment get(int i){
        return this.listeAliments.get(i);
    }
    public int listLenght(){
        return this.listeAliments.size();
    }

    public Aliment get(String name){
        for (int i = 0; i < listeAliments.size(); i++){
            if(listeAliments.get(i).getName().equals(name)){
                return listeAliments.get(i);
            }
        }

        return null;
    }

    public Aliment get(Aliment aliment){
        for (int i = 0; i < listeAliments.size(); i++){
            if(listeAliments.get(i).getName().equals(aliment.getName())){
                return listeAliments.get(i);
            }
        }

        return null;
    }

    public boolean contains(Aliment aliment){
        return this.listeAliments.contains(aliment);
    }

    public boolean contains(String name){
        for (int i = 0; i < listeAliments.size(); i++){
            if(listeAliments.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
