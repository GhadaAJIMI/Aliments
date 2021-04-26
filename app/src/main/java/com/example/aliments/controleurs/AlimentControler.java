package com.example.aliments.controleurs;

import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.ListAliment;

public class AlimentControler {
    public static ListAliment listeAliment;

    // getters and setters
    public static ListAliment getListeAliment() {
        return listeAliment;
    }
    public static void setListeAliment(ListAliment listeAliment) {
        AlimentControler.listeAliment = listeAliment;
    }

    // constructeurs
    public AlimentControler() {
        listeAliment = new ListAliment();
    }

    public AlimentControler(ListAliment listeAliment) {
        this.listeAliment = listeAliment;
    }

    // méthodes
    public static void add(Aliment aliment){
        listeAliment.add(aliment);
    }

    public static Aliment get(int i){
        return listeAliment.get(i);
    }

    public static int listLenght(){
        return listeAliment.listLenght();
    }
}
