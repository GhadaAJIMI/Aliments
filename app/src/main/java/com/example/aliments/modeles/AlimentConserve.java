package com.example.aliments.modeles;

public class AlimentConserve extends Aliments {

    private String type;

    public AlimentConserve(String name, int numImage , String type) {
        super(name , numImage);
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
