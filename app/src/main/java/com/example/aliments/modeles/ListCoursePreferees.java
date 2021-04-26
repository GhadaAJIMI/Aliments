package com.example.aliments.modeles;

import java.util.HashMap;

public class ListCoursePreferees {
    private HashMap<String, CoursePreferee> listCoursesPreferees = new HashMap<String, CoursePreferee>();

    // getters and setters
    public HashMap<String, CoursePreferee> getListCoursesPreferees() {
        return listCoursesPreferees;
    }
    public void setListCoursesPreferees(HashMap<String, CoursePreferee> listCoursesPreferees) {
        this.listCoursesPreferees = listCoursesPreferees;
    }

    // constructeurs
    public ListCoursePreferees() {
        listCoursesPreferees = new HashMap<String, CoursePreferee>();
    }

    public ListCoursePreferees(HashMap<String, CoursePreferee> listCoursesPreferees) {
        this.listCoursesPreferees = listCoursesPreferees;
    }

    // méthodes
    public CoursePreferee get(String name){
        return listCoursesPreferees.get(name);
    }

    public void add(Aliment aliment, String name){
        listCoursesPreferees.get(name).add(aliment);
    }
}
