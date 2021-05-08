package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.aliments.controleurs.UserControler;

import java.util.List;

public class CoursePreferee implements Parcelable {
    private int id;
    private ListAliment listeAliment;
    private String name;
    private double prixTotal;

    protected CoursePreferee(Parcel in) {
        id = in.readInt();
        listeAliment = in.readParcelable(ListAliment.class.getClassLoader());
        name = in.readString();
        prixTotal = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(listeAliment, flags);
        dest.writeString(name);
        dest.writeDouble(prixTotal);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CoursePreferee> CREATOR = new Creator<CoursePreferee>() {
        @Override
        public CoursePreferee createFromParcel(Parcel in) {
            return new CoursePreferee(in);
        }

        @Override
        public CoursePreferee[] newArray(int size) {
            return new CoursePreferee[size];
        }
    };

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Aliment> getListeAliment() {
        return listeAliment.getListeAliments();
    }
    public ListAliment getListeAliment2() {
        return listeAliment;
    }
    public void setListeAliment(ListAliment listeAliment) {
        this.listeAliment = listeAliment;
    }
    public double getPrixTotal() {
        return listeAliment.getPrixTotal();
    }
    public void setPrixTotal(double prixTotal) {
        listeAliment.setPrixTotal(prixTotal);
        this.prixTotal = prixTotal;
    }

    // constructeurs
    public CoursePreferee() {
        id = UserControler.CoursePrefID++;
        listeAliment = new ListAliment();
        this.name = "";
        prixTotal = 0;
    }

    public CoursePreferee(String name) {
        id = UserControler.CoursePrefID++;
        listeAliment = new ListAliment();
        this.name = name;
        prixTotal = 0;
    }

    public CoursePreferee(ListAliment listeAliment, String name) {
        id = UserControler.CoursePrefID++;
        this.listeAliment = listeAliment;
        this.name = name;
        this.prixTotal = getPrixTotal();
    }
    // méthodes
    public int size(){
        return this.listeAliment.size();
    }

    public void add(Aliment aliment){
        this.listeAliment.add(aliment);
        this.prixTotal += aliment.getPrix();
    }

    public void remove(int id){
        Aliment aliment = get(id);
        this.listeAliment.remove(aliment);
        this.prixTotal -= aliment.getPrix();
    }

    public Aliment get(int id){
        for (int i = 0; i < listeAliment.size(); i++){
            if(listeAliment.get(i).getId() == id){
                return listeAliment.get(i);
            }
        }

        return null;
    }

    public boolean contains(Aliment aliment){
        return this.listeAliment.contains(aliment);
    }

    public boolean contains(int id){
        return this.listeAliment.contains(id);
    }
}
