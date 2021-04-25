package com.example.aliments.controleurs;

import com.example.aliments.modeles.ListMagasin;

public class MagasinControler {
    public static ListMagasin listeMagasins;

    public static ListMagasin getListeMagasins() {
        return listeMagasins;
    }

    public static void setListeMagasins(ListMagasin listeMagasins) {
        MagasinControler.listeMagasins = listeMagasins;
    }

    public MagasinControler() {
    }

    public MagasinControler(ListMagasin listeMagasins) {
        this.listeMagasins = listeMagasins;
    }
}
