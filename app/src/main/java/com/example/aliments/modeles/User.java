package com.example.aliments.modeles;

import java.util.HashMap;

public class User implements Seller, Buyer{
    private String name;
    private Magasin magasin;
    private Basket basket;
    private ListCoursePreferees listeCoursesPreferees;

    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Magasin getMagasin() {
        return magasin;
    }
    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
    public Basket getBasket() {
        return basket;
    }
    public void setBasket(Basket basket) {
        this.basket = basket;
    }
    public ListCoursePreferees getListeCoursesPreferees2() {
        return listeCoursesPreferees;
    }
    public void setListeCoursesPreferees2(ListCoursePreferees listeCoursesPreferees) {
        this.listeCoursesPreferees = listeCoursesPreferees;
    }

    // constructeurs
    public User() {
        this.name = "";
        this.magasin = new Magasin();
        this.magasin.setProprio(this);
        this.basket = new Basket();
        listeCoursesPreferees = new ListCoursePreferees();
    }

    public User(String name, Magasin magasin, Basket basket, ListCoursePreferees listeCoursesPreferees) {
        this.name = name;
        this.magasin = magasin;
        this.magasin.setProprio(this);
        this.basket = basket;
        this.listeCoursesPreferees = listeCoursesPreferees;
    }

    // méthodes
    public void addCoursePref(Aliment aliment, String name){
        CoursePreferee c = this.listeCoursesPreferees.get(name);
    }

    public HashMap<String, CoursePreferee> getListeCoursesPreferees(){
        return listeCoursesPreferees.getListCoursesPreferees();
    }

    public void setListeCoursesPreferees(HashMap<String, CoursePreferee> listeCoursesPreferees){
        this.listeCoursesPreferees.setListCoursesPreferees(listeCoursesPreferees);
    }
}