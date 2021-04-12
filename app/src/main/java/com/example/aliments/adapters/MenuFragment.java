package com.example.aliments.adapters;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aliments.MainActivity;
import com.example.aliments.R;
import com.example.aliments.vues.AcceuilAcheteurActivity;
import com.example.aliments.vues.ListeCoursesPrefereesActivity;

public class MenuFragment extends Fragment {
    private Button cousesPrefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu , container , false);

         cousesPrefs = (Button) v.findViewById(R.id.Coursespref);
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