package com.example.aliments.modeles;

public class Aliment {
    private String name;
    private double prix;
    private String imageMemic;

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public String getImageMemic() {
        return imageMemic;
    }
    public void setImageMemic(String imageMemic) {
        this.imageMemic = imageMemic;
    }

    // constructeur
    public Aliment() {
    }

    public Aliment(String name, double prix, String imageMemic) {
        this.name = name;
        this.prix = prix;
        this.imageMemic = imageMemic;
    }

    // méthodes

}
