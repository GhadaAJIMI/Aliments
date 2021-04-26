package com.example.aliments.modeles;

public class AbstractFactoryFrais extends AlimentAbstractFactory {

    @Override
    public Aliments buildAliment(int typeAliment)throws Throwable {
        switch (typeAliment){
            case FRAIS:
                int modernRedRandom = (int)(5*Math.random()+6);
                if(modernRedRandom == 11) modernRedRandom--;
                return new AlimentsFrais("Frais" , modernRedRandom , "Frais");
            default: throw new Throwable("Aliment not found");
        }
    }

    @Override
    public Shop buildShop(int typeShop) throws Throwable {
        switch (typeShop) {
            case SHOPFRAIS:
                int modernRedRandom = (int)(5*Math.random()+5);
                return new ShopFrais(modernRedRandom , "FRAIS");
            default: throw new Throwable("Shop not found");
        }
    }




}
