package com.example.aliments.modeles;

public class Aliments {
    private String name;
    private int numIm;


    public Aliments(String name , int numImage) {
        this.name = name;
        this.numIm = numImage;

    }

    public String getName() {
        return name;
    }

    public int getNumIm() {
        return numIm;
    }
}
