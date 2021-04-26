package com.example.aliments.modeles;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Aliment> listeProduit;
    private double prixTotal;

    // getters and setters
    public List<Aliment> getListeProduit() {
        return listeProduit;
    }
    public void setListeProduit(List<Aliment> listeProduit) {
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
        listeProduit = new ArrayList<>();
    }

    public Basket(List<Aliment> listeProduit, double prixTotal) {
        this.listeProduit = listeProduit;
        this.prixTotal = prixTotal;
    }
}
