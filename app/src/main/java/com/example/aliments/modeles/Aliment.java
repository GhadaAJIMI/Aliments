package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

public class Aliment implements Parcelable {
    private String name;
    private double prix;
    private int rsc;

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getRsc() {
        return rsc;
    }
    public void setRsc(int rsc) {
        this.rsc = rsc;
    }

    // constructeur
    public Aliment() {
    }

    public Aliment(String name, double prix) {
        this.name = name;
        this.prix = prix;
        this.rsc = 0;
    }

    public Aliment(String name, double prix, int rsc) {
        this.name = name;
        this.prix = prix;
        this.rsc = rsc;
    }

    protected Aliment(Parcel in) {
        name = in.readString();
        prix = in.readDouble();
        rsc = in.readInt();
    }

    public static final Creator<Aliment> CREATOR = new Creator<Aliment>() {
        @Override
        public Aliment createFromParcel(Parcel in) {
            return new Aliment(in);
        }

        @Override
        public Aliment[] newArray(int size) {
            return new Aliment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(prix);
        dest.writeInt(rsc);
    }
}
