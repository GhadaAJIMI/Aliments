package com.example.aliments.modeles;

import java.util.List;

public class User implements Seller, Buyer{
    private String name;
    private Basket panier;
    private List<List<Aliment>> listeCoursesPreferees;

    //getters and setters
    public Basket getPanier() {
        return panier;
    }
    public void setPanier(Basket panier) {
        this.panier = panier;
    }
    public List<List<Aliment>> getListeCoursesPreferees() {
        return listeCoursesPreferees;
    }
    public void setListeCoursesPreferees(List<List<Aliment>> listeCoursesPreferees) {
        this.listeCoursesPreferees = listeCoursesPreferees;
    }

    // constructeurs
    public User() {
    }
    public User(String name) {
        this.name = name;
    }

    // méthodes

}
