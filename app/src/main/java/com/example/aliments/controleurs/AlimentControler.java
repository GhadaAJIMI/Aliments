package com.example.aliments.controleurs;

import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.ListAliment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlimentControler {
    public static int AlimentID = 0;
    public static ListAliment listeAliment;
    public static ListAliment listeAlimentModifies;
    public static Aliment aliment;

    // getters and setters
    public static List<Aliment> getListeAliment2() {
        return listeAliment.getListeAliments();
    }
    public static ListAliment getListeAliment() {
        return listeAliment;
    }
    public static void setListeAliment(ListAliment listeAliment) {
        AlimentControler.listeAliment = listeAliment;
    }
    public static List<Aliment> getListeAlimentModifies() {
        return listeAlimentModifies.getListeAliments();
    }
    public static ListAliment getListeAlimentModifies2() {
        return listeAlimentModifies;
    }
    public static void setListeAlimentModifies(ListAliment listeAlimentModifies) {
        AlimentControler.listeAlimentModifies = listeAlimentModifies;
    }
    public static Aliment getAliment() {
        return aliment;
    }
    public static void setAliment(Aliment aliment) {
        AlimentControler.aliment = aliment;
    }

    // constructeurs
    public AlimentControler() {
        listeAliment = new ListAliment();
        listeAlimentModifies = new ListAliment();
    }

    public AlimentControler(ListAliment listeAliment) {
        this.listeAliment = listeAliment;
        listeAlimentModifies = new ListAliment();
    }

    // méthodes
    public static void add(Aliment aliment){
        listeAliment.add(aliment);
    }

    public static Aliment get(int i){
        return listeAliment.get(i);
    }

    public static Aliment get(String name){
        return listeAliment.get(name);
    }

    public static int listLenght(){
        return listeAliment.listLenght();
    }

    public static void addListeAlimentModifies(Aliment aliment){
        listeAlimentModifies.add(aliment);
    }

    public static Aliment getListeAlimentModifies(int i){
        return listeAlimentModifies.get(i);
    }

    public static Aliment getListeAlimentModifies(String name){
        return listeAlimentModifies.get(name);
    }

    public static int listLenghtListeAlimentModifies(){
        return listeAlimentModifies.listLenght();
    }
}
