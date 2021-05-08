package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.adapters.PictureFragment;
import com.example.aliments.adapters.StorageFragment;
import com.example.aliments.controleurs.UserControler;

public class AjoutAlimentActivity extends AppCompatActivity implements IPictureActivity, IStorageActivity {

    private Bitmap picture;
    private PictureFragment pictureFragment;
    private StorageFragment storageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_aliment);

        findViewById( R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjoutAlimentActivity.this, AcceuilVendeurActivity.class);
                startActivity(intent);
            }
        });

        findViewById( R.id.buttonAjoutAliment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView prixText = (TextView) findViewById(R.id.prixNouveauAliment);
                TextView nomText = (TextView) findViewById(R.id.nomNouveauAliment);
                String nom = nomText.getText().toString();
                String prix = prixText.getText().toString();
                try {
                    int src = AjoutAlimentActivity.this.getResources().getIdentifier("banane", "drawable", AjoutAlimentActivity.this.getPackageName());
                    UserControler.get(1).getMagasin().ajouterAliment(nom, Double.valueOf(prix),src, 4.0, 1);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Aliment "+nom+" de prix "+prix+"€ ajouté !", Toast.LENGTH_LONG).show();
            }
        });

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
                    Toast toast = Toast.makeText(getApplicationContext(), "Write permission NOT granted", Toast.LENGTH_LONG);
                    toast.show();
                }
            } break;
            case REQUEST_MEDIA_READ: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    storageFragment.saveToInternalStorage(picture);
                    Toast toast = Toast.makeText(getApplicationContext(), "Read permission granted", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Read permission NOT granted", Toast.LENGTH_LONG);
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
