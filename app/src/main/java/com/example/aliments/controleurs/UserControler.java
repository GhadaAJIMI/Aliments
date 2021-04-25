package com.example.aliments.controleurs;

import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.ListUser;
import com.example.aliments.modeles.Magasin;
import com.example.aliments.modeles.User;

import java.util.List;

public class UserControler {
    public static ListUser listeUsers;

    public static ListUser getListeUsers() {
        return listeUsers;
    }
    public static void setListeUsers(ListUser listeUsers) {
        UserControler.listeUsers = listeUsers;
    }

    public UserControler(){
        listeUsers = new ListUser();
    }

    public UserControler(ListUser listeUsers) {
        this.listeUsers = listeUsers;
    }

    public static void add(User utilisateur){
        listeUsers.add(utilisateur);
    }

    public static void remove(User utilisateur){
        listeUsers.remove(utilisateur);
    }

    public static void get(int i){
        listeUsers.get(i);
    }
}
