package com.example.aliments.modeles;

import java.util.List;

public class Magasin {
    private Seller proprio;
    private List<ProduitAlimentaire> listeProduitAlimentaires;
    private AlimentFactory alimentFactory;

    // getters and setters
    public Seller getProprio() {
        return proprio;
    }
    public void setProprio(Seller proprio) {
        this.proprio = proprio;
    }
    public List<ProduitAlimentaire> getListeProduitAlimentaires() {
        return listeProduitAlimentaires;
    }
    public void setListeProduitAlimentaires(List<ProduitAlimentaire> listeProduitAlimentaires) {
        this.listeProduitAlimentaires = listeProduitAlimentaires;
    }

    // constructeurs
    public Magasin() {super();}

    public Magasin(Seller proprio, List<ProduitAlimentaire> listeProduitAlimentaires) {
        this.proprio = proprio;
        this.listeProduitAlimentaires = listeProduitAlimentaires;
    }

}
