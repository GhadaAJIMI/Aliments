package com.example.aliments.modeles;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class ListCoursePreferees implements Parcelable {
    private HashMap<String, CoursePreferee> listCoursesPreferees = new HashMap<String, CoursePreferee>();

    protected ListCoursePreferees(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListCoursePreferees> CREATOR = new Creator<ListCoursePreferees>() {
        @Override
        public ListCoursePreferees createFromParcel(Parcel in) {
            return new ListCoursePreferees(in);
        }

        @Override
        public ListCoursePreferees[] newArray(int size) {
            return new ListCoursePreferees[size];
        }
    };

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

    public void add(String name){
        listCoursesPreferees.put(name, new CoursePreferee(name));
    }

    public void add(CoursePreferee coursePref){
        listCoursesPreferees.put(coursePref.getName(), coursePref);
    }
}
