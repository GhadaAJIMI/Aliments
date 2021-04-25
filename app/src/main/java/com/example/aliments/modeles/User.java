package com.example.aliments.modeles;

import java.util.List;

public class User implements Seller, Buyer{
    private String name;
    private Magasin magasin;

    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // constructeurs
    public User() {
    }
    public User(String name, Magasin magasin) {
        this.name = name;
        this.magasin = magasin;
        this.magasin.setProprio(this);
    }

    // méthodes

}
