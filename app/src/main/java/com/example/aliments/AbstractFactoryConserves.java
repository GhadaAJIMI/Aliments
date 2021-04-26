package com.example.aliments;



import com.example.aliments.modeles.AlimentConserve;
import com.example.aliments.modeles.Aliments;
import com.example.aliments.modeles.Shop;
import com.example.aliments.modeles.ShopConserve;

public class AbstractFactoryConserves extends AlimentAbstractFactory {


    @Override
    public Aliments buildAliment(int typeAliment)throws Throwable {
        switch (typeAliment){
            case CONSERVES:
                int modernRedRandom = (int)(5*Math.random()+1);
                return new AlimentConserve("Conserves" , modernRedRandom , "Conserves");
            default: throw new Throwable("Aliment not found");
        }
    }

    @Override
    public Shop buildShop(int typeShop) throws Throwable {
        switch (typeShop) {
            case SHOPCONSERVES:
                int modernRedRandom = (int)(5*Math.random()+1);
                return new ShopConserve(modernRedRandom , "CONSERVES");
            default: throw new Throwable("Shop not found");
        }
    }
}
