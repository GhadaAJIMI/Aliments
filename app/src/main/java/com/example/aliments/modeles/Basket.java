package com.example.aliments.modeles;

import java.util.List;

public class Basket {
    private List<Produit> listeProduit;
    private double prixTotal;

    // getters and setters
    public List<Produit> getListeProduit() {
        return listeProduit;
    }
    public void setListeProduit(List<Produit> listeProduit) {
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
    }

    public Basket(List<Produit> listeProduit, double prixTotal) {
        this.listeProduit = listeProduit;
        this.prixTotal = prixTotal;
    }
}
