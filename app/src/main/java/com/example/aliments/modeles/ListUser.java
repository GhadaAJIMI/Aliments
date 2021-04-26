package com.example.aliments.modeles;

import java.util.ArrayList;
import java.util.List;

public class ListUser {
    private List<User> listeUsers;

    public List<User> getListeUsers() {
        return listeUsers;
    }

    public void setListeUsers(List<User> listeUsers) {
        this.listeUsers = listeUsers;
    }

    public ListUser(){
        listeUsers = new ArrayList<User>();
    }

    public ListUser(List<User> listeUsers) {
        this.listeUsers = listeUsers;
    }

    public void add(User utilisateur){
        listeUsers.add(utilisateur);
    }

    public void remove(User utilisateur){
        listeUsers.remove(utilisateur);
    }

    public User get(int i){
        return listeUsers.get(i);
    }
}
