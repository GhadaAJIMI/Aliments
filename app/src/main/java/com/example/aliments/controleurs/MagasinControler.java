package com.example.aliments.controleurs;

import com.example.aliments.modeles.ListMagasin;
import com.example.aliments.modeles.Magasin;

import java.util.List;

public class MagasinControler {
    public static int MagasinID = 0;
    public static ListMagasin listeMagasins;

    // getters and setters
    public static List<Magasin> getListeMagasins() {
        return listeMagasins.getListeMagasins();
    }
    public static void setListeMagasins(List<Magasin> listeMagasins) {
        MagasinControler.listeMagasins.setListeMagasins(listeMagasins);
    }

    // constructeurs
    public MagasinControler() {
        listeMagasins = new ListMagasin();
    }
    public MagasinControler(ListMagasin listeMagasins) {
        this.listeMagasins = listeMagasins;
    }
    public MagasinControler(List<Magasin> listeMagasins) {
        this.listeMagasins.setListeMagasins(listeMagasins);
    }

    // méthodes
    public static void add(Magasin magasin){
        listeMagasins.add(magasin);
    }

    public static Magasin get(int i){
        return listeMagasins.get(i);
    }

    public static int listLenght(){
        return listeMagasins.listLenght();
    }
}
