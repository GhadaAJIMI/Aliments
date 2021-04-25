package com.example.aliments.modeles;

import java.util.List;

public class ListUser {
    private List<User> listeUsers;

    public List<User> getListeUsers() {
        return listeUsers;
    }

    public void setListeUsers(List<User> listeUsers) {
        this.listeUsers = listeUsers;
    }

    public ListUser(){}

    public ListUser(List<User> listeUsers) {
        this.listeUsers = listeUsers;
    }

    public void add(User utilisateur){
        listeUsers.add(utilisateur);
    }

    public void remove(User utilisateur){
        listeUsers.remove(utilisateur);
    }

    public void get(int i){
        listeUsers.get(i);
    }
}
