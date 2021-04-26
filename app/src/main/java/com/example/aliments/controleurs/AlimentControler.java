package com.example.aliments.controleurs;

import com.example.aliments.modeles.ListAliment;

public class AlimentControler {
    public static ListAliment listeAliment;

    public static ListAliment getListeAliment() {
        return listeAliment;
    }

    public static void setListeAliment(ListAliment listeAliment) {
        AlimentControler.listeAliment = listeAliment;
    }

    public AlimentControler() {
    }

    public AlimentControler(ListAliment listeAliment) {
        this.listeAliment = listeAliment;
    }
}
