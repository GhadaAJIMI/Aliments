package com.example.aliments.controleurs;

import com.example.aliments.modeles.CoursePreferee;
import com.example.aliments.modeles.ListUser;
import com.example.aliments.modeles.Magasin;
import com.example.aliments.modeles.User;

import java.util.List;

public class UserControler {
    public static ListUser listeUsers;

    // getters and setters
    public static ListUser getListeUsers() {
        return listeUsers;
    }
    public static void setListeUsers(ListUser listeUsers) {
        UserControler.listeUsers = listeUsers;
    }

    // constructeurs
    public UserControler(){
        listeUsers = new ListUser();
    }
    public UserControler(ListUser listeUsers) {
        this.listeUsers = listeUsers;
    }

    // méthodes
    public static void add(User utilisateur){
        listeUsers.add(utilisateur);
    }

    public static void remove(User utilisateur){
        listeUsers.remove(utilisateur);
    }

    public static User get(int i){
        return listeUsers.get(i);
    }
}
