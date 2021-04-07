package com.example.aliments.modeles;

import java.util.List;

public class CoursePreferee {
    private List<Aliment> listeProduit;
    private String name;

    // getters and setters
    public List<Aliment> getListeProduitAlimentaire() {
        return listeProduit;
    }
    public void setListeProduitAlimentaire(List<Aliment> listeProduit) {
        this.listeProduit = listeProduit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // constructeurs
    public CoursePreferee() {
    }

    public CoursePreferee(List<Aliment> listeProduit, String name) {
        this.listeProduit = listeProduit;
        this.name = name;
    }

    // méthodes
    public void ajouterProduit(int type) throws Throwable{
        listeProduit.add(AlimentFactory.build(type));
    }

    public void supprimerProduit(Aliment aliment){
        listeProduit.remove(aliment);
    }
}
