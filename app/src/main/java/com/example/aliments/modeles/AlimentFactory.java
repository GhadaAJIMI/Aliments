package com.example.aliments.modeles;

public class AlimentFactory {
    public static final int PRODUIT_ALIMENTAIRE = 1;
    public static final int PRODUIT_BRICOLAGE = 2;

    static Aliment build(int type) throws Throwable{
        switch (type){
            case PRODUIT_ALIMENTAIRE : return new AlimentFrais();
            case PRODUIT_BRICOLAGE : return new AlimentBuvable();
            default: throw new Throwable("unknown product");
        }
    }
}


