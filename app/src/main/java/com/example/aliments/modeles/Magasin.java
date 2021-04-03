package com.example.aliments.modeles;

import java.util.List;

public class Magasin {
    private Seller proprio;
    private List<Aliment> listeAliments;
    private AlimentFactory alimentFactory;

    // getters and setters
    public Seller getProprio() {
        return proprio;
    }
    public void setProprio(Seller proprio) {
        this.proprio = proprio;
    }
    public List<Aliment> getListeAliments() {
        return listeAliments;
    }
    public void setListeAliments(List<Aliment> listeAliments) {
        this.listeAliments = listeAliments;
    }

    // constructeurs
    public Magasin() {super();}

    public Magasin(Seller proprio, List<Aliment> listeAliments) {
        this.proprio = proprio;
        this.listeAliments = listeAliments;
    }

}
