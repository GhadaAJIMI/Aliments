package com.example.aliments.adapters;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.aliments.R;
import com.example.aliments.controleurs.UserControler;
import com.example.aliments.vues.ListeCoursesPrefereesActivity;

public class MenuFragment extends Fragment {
    private Button cousesPrefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu , container , false);
        cousesPrefs = (Button) v.findViewById(R.id.Coursespref);

        ListView listCourse = v.findViewById(R.id.ListeCoursesPref);
        listCourse.setAdapter(new ListeCoursesPrefEnMenuPrincipalAdapter(v.getContext(), UserControler.get(0).getListeCoursesPreferees()));

        cousesPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListeCoursesPrefereesActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}