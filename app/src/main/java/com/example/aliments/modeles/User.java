package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User implements Seller, Buyer, Parcelable {
    private String name;
    private Magasin magasin;
    private Basket basket;
    private ListCoursePreferees listeCoursesPreferees;
    private ListAliment tousLesAliments;
    public CoursePreferee currentList;

    protected User(Parcel in) {
        name = in.readString();
        magasin = in.readParcelable(Magasin.class.getClassLoader());
        listeCoursesPreferees = in.readParcelable(ListCoursePreferees.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(magasin, flags);
        dest.writeParcelable(listeCoursesPreferees, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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
    public void setListeCoursesPreferees(ListCoursePreferees listeCoursesPreferees) {
        this.listeCoursesPreferees = listeCoursesPreferees;
    }
    public List<Aliment> getTousLesAliments() {
        return tousLesAliments.getListeAliments();
    }
    public ListAliment getTousLesAliments2() {
        return tousLesAliments;
    }
    public void setTousLesAliments(ListAliment tousLesAliments) {
        this.tousLesAliments = tousLesAliments;
    }

    // constructeurs
    public User() {
        this.name = "";
        this.magasin = new Magasin();
        this.magasin.setProprio(this);
        this.basket = new Basket();
        listeCoursesPreferees = new ListCoursePreferees();
        tousLesAliments = new ListAliment();
    }

    public User(String name, Magasin magasin, Basket basket, ListCoursePreferees listeCoursesPreferees) {
        this.name = name;
        this.magasin = magasin;
        this.magasin.setProprio(this);
        this.basket = basket;
        this.listeCoursesPreferees = listeCoursesPreferees;
        this.tousLesAliments = new ListAliment();
        remplirListeTotaleDAliment();
    }

    // m??thodes
    public void addCoursePref(Aliment aliment, String name){
        CoursePreferee c = this.listeCoursesPreferees.get(name);
    }

    public HashMap<String, CoursePreferee> getListeCoursesPreferees(){
        return listeCoursesPreferees.getListCoursesPreferees();
    }

    public List<CoursePreferee> getListeCoursesPreferees3(){
        return listeCoursesPreferees.getListCoursesPreferees3();
    }

    public void setListeCoursesPreferees(HashMap<String, CoursePreferee> listeCoursesPreferees){
        this.listeCoursesPreferees.setListCoursesPreferees(listeCoursesPreferees);
    }

    // a revoir (contains(aliment.getName()))
    public void remplirListeTotaleDAliment(){
        for(CoursePreferee coursePref: getListeCoursesPreferees3()){
            for(Aliment aliment: coursePref.getListeAliment()){
                if(!this.tousLesAliments.contains(aliment)){
                    this.tousLesAliments.add(new Aliment(aliment));
                }
            }
        }

        for(Aliment aliment: this.basket.getListeProduit()){
            if(!this.tousLesAliments.contains(aliment)){
                this.tousLesAliments.add(aliment);
            }
        }
    }

    // a revoir (contains(aliment.getName()))
    public void viderListeTotaleDAliment(){
        this.tousLesAliments= new ListAliment();
    }

    public void removeListeTotaleDAliment(Aliment aliment){
        Aliment tmp = aliment;
        for(Aliment ali: this.getTousLesAliments()){
            if(ali.getId() == aliment.getId()){
                tmp = ali;
            }
        }

        this.getTousLesAliments().remove(tmp);
    }
}