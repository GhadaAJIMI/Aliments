package com.example.aliments.adapters;

import android.Manifest;
import android.content.ContentValues;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.vues.IStorageActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Fragment pour prendre et sauvegarder une image (Bitmap)
 * buttonSave pour sauvegarder l'image donnée par l'activité parent
 * buttonLoad pour rapeller la méthode onPictureLoad
 * Activer/Désaciver les boutons pour interdire certains traitements
 */
public class StorageFragment extends Fragment {
    private IStorageActivity activity;
    private Button buttonSave;

   // private Button buttonLoad;
    private String pictureName;

    private String directoryName;

    public StorageFragment() {
    }

    public StorageFragment(IStorageActivity activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_storage, container, false);
        pictureName = "fraise.jpg";
        ContextWrapper contextWrapper = new ContextWrapper(getContext());
        directoryName = contextWrapper.getDir("imageDir", ContextWrapper.MODE_PRIVATE).getPath();

        //buttonLoad = rootView.findViewById(R.id.buttonLoadPicture);
        buttonSave = rootView.findViewById(R.id.buttonSavePicture);
        this.setEnableSaveButton();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap picture = activity.getPictureToSave();
                if(picture !=null){
                    if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                IStorageActivity.REQUEST_MEDIA_WRITE);
                    } else { // Permission déjà obtenue
                        saveToInternalStorage(picture);
                    }
                }
            }
        });

      /*  buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                IStorageActivity.REQUEST_MEDIA_READ);
                    } else { // Permission déjà obtenue
                        activity.onPictureLoad(loadImageFromStorage());
                    }
            }
        });*/

        return rootView;
    }

    public Bitmap loadImageFromStorage() {
        try{
            File file = new File(directoryName, pictureName);
            Toast toast = Toast.makeText(getContext(), "Dernière image récupérée", Toast.LENGTH_LONG);
            toast.show();
            return BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveToInternalStorage(Bitmap picture) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, pictureName);
        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/*");
        contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, directoryName);
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        File file = new File (directoryName, pictureName);
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            picture.compress(Bitmap.CompressFormat.PNG, 90, fos);
            Toast toast = Toast.makeText(getContext(), "Photo enregistrée", Toast.LENGTH_LONG);
            toast.show();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void setDisableSaveButton(){
        buttonSave.setEnabled(false);
    }
    public void setEnableSaveButton(){
        buttonSave.setEnabled(true);
    }
}