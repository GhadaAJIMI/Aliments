package com.example.aliments.modeles;

import java.util.List;

public class CourcePreferee {
    private List<Produit> listeProduit;
    private String name;

    // getters and setters
    public List<Produit> getListeProduitAlimentaire() {
        return listeProduit;
    }
    public void setListeProduitAlimentaire(List<Produit> listeProduit) {
        this.listeProduit = listeProduit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // constructeurs
    public CourcePreferee() {
    }

    public CourcePreferee(List<Produit> listeProduit, String name) {
        this.listeProduit = listeProduit;
        this.name = name;
    }

    // méthodes
    public void ajouterProduit(int type) throws Throwable{
        listeProduit.add(AlimentFactory.build(type));
    }

    public void supprimerProduit(Produit produit){
        listeProduit.remove(produit);
    }
}
