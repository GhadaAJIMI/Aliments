package com.example.aliments.modeles;

import java.util.HashMap;
import java.util.List;

public class Magasin {
    private Seller proprio;
    private HashMap<Produit, Double> listeProduits;

    // getters and setters
    public Seller getProprio() {
        return proprio;
    }
    public void setProprio(Seller proprio) {
        this.proprio = proprio;
    }
    public HashMap<Produit, Double> getListeProduits() {
        return listeProduits;
    }
    public void setListeProduits(HashMap<Produit, Double> listeProduits) {
        this.listeProduits = listeProduits;
    }

    // constructeurs
    public Magasin() {super();}

    public Magasin(Seller proprio, HashMap<Produit, Double> listeProduits) {
        this.proprio = proprio;
        this.listeProduits = listeProduits;
    }

    // méthodes
    public void ajouterAliment(String name, double price, String imageMemic, double quantite, int type) throws Throwable{
        Produit produit = AlimentFactory.build(type);
        produit.setPrix(price);
        produit.setName(name);
        produit.setImageMemic(imageMemic);

        listeProduits.put(produit, quantite);
    }

    public void ajouterAliment(String name, double price, double quantite, int type) throws Throwable{
        Produit produit = AlimentFactory.build(type);
        produit.setPrix(price);
        produit.setName(name);

        listeProduits.put(produit, quantite);
    }

}
