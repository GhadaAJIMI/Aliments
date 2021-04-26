package com.example.aliments.modeles;

public class ShopFrais extends Shop {
    private String typeShop;

    public ShopFrais(int numImage  , String typeShop) {
        super(numImage);
        this.typeShop = typeShop;
    }
}
