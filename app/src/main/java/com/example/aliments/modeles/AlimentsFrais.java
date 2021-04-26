package com.example.aliments.modeles;

public class AlimentsFrais extends Aliments {

    private String type;

    public AlimentsFrais(String name, int numImage , String type) {
        super(name, numImage);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
