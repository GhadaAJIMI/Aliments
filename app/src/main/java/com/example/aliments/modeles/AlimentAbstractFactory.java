package com.example.aliments.modeles;


import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.Aliments;
import com.example.aliments.modeles.Shop;

public abstract class AlimentAbstractFactory {
    int typeAliment;
    int typeShop;
    public static final int FRAIS = 1;
    public static final int CONSERVES = 2;
    public static final int SHOPCONSERVES = 102;
    public static final int SHOPFRAIS = 101;


    public abstract Aliments buildAliment(int typeAliment ) throws Throwable;
    public abstract Shop buildShop(int typeShop) throws Throwable;
}
