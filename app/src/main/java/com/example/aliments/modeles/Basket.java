package com.example.aliments.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {
    private HashMap<Aliment, Double> listeProduit;
    private double prixTotal;

    // getters and setters
    public HashMap<Aliment, Double> getListeProduit() {
        return listeProduit;
    }
    public void setListeProduit(HashMap<Aliment, Double> listeProduit) {
        this.listeProduit = listeProduit;
    }
    public double getPrixTotal() {
        return prixTotal;
    }
    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    // constructeur
    public Basket() {
        listeProduit = new HashMap<Aliment, Double>();
    }

    public Basket(HashMap<Aliment, Double> listeProduit, double prixTotal) {
        this.listeProduit = listeProduit;
        this.prixTotal = prixTotal;
    }

    // méthodes
    public void add(Aliment aliment){
        listeProduit.put(aliment, 1.0);
    }

    public void add(Aliment aliment, Double i){
        listeProduit.put(aliment, listeProduit.get(aliment) + i);
    }

    public Aliment get(int i){
        List<Aliment> liste = new ArrayList(listeProduit.keySet());
        return liste.get(i);
    }

    public Boolean contains(Aliment aliment){
        return listeProduit.containsKey(aliment);
    }
}
