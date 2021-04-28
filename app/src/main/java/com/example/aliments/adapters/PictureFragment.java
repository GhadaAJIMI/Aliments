package com.example.aliments.adapters;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aliments.R;
import com.example.aliments.vues.IPictureActivity;

public class PictureFragment extends Fragment {

    ImageView imageView;

    public PictureFragment() {
        // Required empty public constructor
    }

   /* public static PictureFragment newInstance(String param1, String param2) {
        PictureFragment fragment = new PictureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_picture, container, false);
        imageView = rootView.findViewById(R.id.imageView);
        rootView.findViewById(R.id.buttonImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[] {Manifest.permission.CAMERA},
                            IPictureActivity.REQUEST_CAMERA);
                } else { //Permission déjà obtenue
                    takePicture();
                }
            }
        });

        return rootView;
    }

    public void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        getActivity().startActivityForResult(intent, IPictureActivity.REQUEST_CAMERA);
    }

    public void setImage(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }
}