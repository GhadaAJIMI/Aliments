package com.example.aliments.modeles;

public class AlimentFactory {
    public static final int PRODUIT_ALIMENTAIRE = 1;
    public static final int PRODUIT_HYGENIQUE = 2;
    public static final int PRODUIT_BRICOLAGE = 3;
    public static final int PRODUIT_JARDINAGE = 4;
    public static final int PRODUIT_VESTIMENTAIRE = 5;

    static Produit build(int type) throws Throwable{
        switch (type){
            case PRODUIT_ALIMENTAIRE : return new ProduitAlimentaire();
            case PRODUIT_HYGENIQUE : return new ProduitHygenique();
            case PRODUIT_BRICOLAGE : return new ProduitBricolage();
            case PRODUIT_JARDINAGE : return new ProduitJardinage();
            case PRODUIT_VESTIMENTAIRE : return new ProduitVestimentaire();
            default: throw new Throwable("unknown product");
        }
    }
}
