package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.adapters.PictureFragment;
import com.example.aliments.adapters.StorageFragment;

public class AjoutAlimentActivity extends AppCompatActivity implements IPictureActivity, IStorageActivity {

    private Bitmap picture;
    private PictureFragment pictureFragment;
    private StorageFragment storageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_aliment);

        pictureFragment = (PictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentPicture);
        if(pictureFragment == null){
            pictureFragment = new PictureFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentPicture, pictureFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        storageFragment = (StorageFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentPicture);
        if(storageFragment == null){
            storageFragment = new StorageFragment(this);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentStorage, storageFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    /**
     * callback from requestPermission
     * @param requestCode
     * @param permisions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permisions, int[] grantResults){
        switch (requestCode){
            case REQUEST_CAMERA: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast toast = Toast.makeText(getApplicationContext(), "CAMERA authorization granted", Toast.LENGTH_LONG);
                    toast.show();
                    pictureFragment.takePicture();
                    storageFragment.setEnableSaveButton();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "CAMERA authorization NOT granted", Toast.LENGTH_LONG);
                    toast.show();
                }
            } break;
            case REQUEST_MEDIA_WRITE: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    storageFragment.saveToInternalStorage(picture);
                    Toast toast = Toast.makeText(getApplicationContext(), "Write permission granted", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Write prmission NOT granted", Toast.LENGTH_LONG);
                    toast.show();
                }
            } break;
            case REQUEST_MEDIA_READ: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    storageFragment.saveToInternalStorage(picture);
                    Toast toast = Toast.makeText(getApplicationContext(), "Read permission granted", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Read prmission NOT granted", Toast.LENGTH_LONG);
                    toast.show();
                }
            } break;
        }
    }

    /**
     * callback fram startActivity
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CAMERA){
            if(resultCode == RESULT_OK){
                picture = (Bitmap) data.getExtras().get("data");
                pictureFragment.setImage(picture);
            } else if (resultCode == RESULT_CANCELED){
                Toast toast = Toast.makeText(getApplicationContext(), "picture canceled", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Action failed", Toast.LENGTH_LONG);
                toast.show();
            }

        }
    }

    @Override
    public void onPictureLoad(Bitmap bitmap) {
        pictureFragment.setImage(bitmap);
    }

    @Override
    public Bitmap getPictureToSave() {
        return picture;
    }
}