package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ListMagasin implements Parcelable {
    private List<Magasin> listeMagasins;

    protected ListMagasin(Parcel in) {
        listeMagasins = in.createTypedArrayList(Magasin.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //dest.writeTypedList(listeMagasins);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListMagasin> CREATOR = new Creator<ListMagasin>() {
        @Override
        public ListMagasin createFromParcel(Parcel in) {
            return new ListMagasin(in);
        }

        @Override
        public ListMagasin[] newArray(int size) {
            return new ListMagasin[size];
        }
    };

    public List<Magasin> getListeMagasins() {
        return listeMagasins;
    }
    public void setListeMagasins(List<Magasin> listeMagasins) {
        this.listeMagasins = listeMagasins;
    }

    // constructeur
    public ListMagasin() {
        this.listeMagasins = new ArrayList<Magasin>();
    }

    public ListMagasin(List<Magasin> listeMagasins) {
        this.listeMagasins = listeMagasins;
    }

    // méthodes

    public void add(Magasin magasin){
        listeMagasins.add(magasin);
    }

    public void remove(Magasin magasin){
        listeMagasins.remove(magasin);
    }
}
