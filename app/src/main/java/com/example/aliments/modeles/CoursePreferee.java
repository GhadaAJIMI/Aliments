package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

public class CoursePreferee implements Parcelable {
    private ListAliment listeAliment;
    private String name;
    private double prixTotal;

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ListAliment getListeAliment() {
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
        listeAliment = new ListAliment();
        this.name = "";
        prixTotal = 0;
    }

    public CoursePreferee(ListAliment listeAliment, String name) {
        this.listeAliment = listeAliment;
        this.name = name;
        this.prixTotal = getPrixTotal();
    }

    protected CoursePreferee(Parcel in) {
        listeAliment = in.readParcelable(ListAliment.class.getClassLoader());
        name = in.readString();
        prixTotal = in.readDouble();
    }

    // méthodes

    @Override
    public void writeToParcel(Parcel dest, int flags) {
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

    public void add(Aliment aliment){
        this.listeAliment.add(aliment);
        this.prixTotal += aliment.getPrix();
    }
}
