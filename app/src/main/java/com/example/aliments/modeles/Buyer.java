package com.example.aliments.modeles;

import java.util.List;

public class Buyer extends User{
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

    //constructeurs
    public Buyer() {super();
    }

    public Buyer(String name, Basket panier, List<List<Aliment>> listeCoursesPreferees) {
        super(name);
        this.panier = panier;
        this.listeCoursesPreferees = listeCoursesPreferees;
    }

    // méthodes

    // Ajouter au panier

    // Supprimer du panier

    // Créer une nouvelle liste de cources preferees

    // Supprimer une liste de cources preferees

    // Ajouter aliment à une de cources preferees

    // Supprimer aliment d'une de cources preferees

    // ...
}
