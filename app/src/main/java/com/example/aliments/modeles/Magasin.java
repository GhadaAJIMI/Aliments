package com.example.aliments.modeles;

import java.util.HashMap;

public class Magasin {
    private Seller proprio;
    private HashMap<Aliment, Double> listeProduits;

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

    // constructeurs
    public Magasin() {super();}

    public Magasin(Seller proprio, HashMap<Aliment, Double> listeProduits) {
        this.proprio = proprio;
        this.listeProduits = listeProduits;
    }

    // méthodes
    public void ajouterAliment(String name, double price, String imageMemic, double quantite, int type) throws Throwable{
        Aliment aliment = AlimentFactory.build(type);
        aliment.setPrix(price);
        aliment.setName(name);
        aliment.setImageMemic(imageMemic);

        listeProduits.put(aliment, quantite);
    }

    public void ajouterAliment(String name, double price, double quantite, int type) throws Throwable{
        Aliment aliment = AlimentFactory.build(type);
        aliment.setPrix(price);
        aliment.setName(name);

        listeProduits.put(aliment, quantite);
    }

}
