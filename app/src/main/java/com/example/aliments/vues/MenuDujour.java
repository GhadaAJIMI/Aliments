package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.aliments.AbstractFactoryConserves;
import com.example.aliments.AbstractFactoryFrais;
import com.example.aliments.AlimentAbstractFactory;
import com.example.aliments.R;
import com.example.aliments.modeles.Aliment;
import com.example.aliments.modeles.Aliments;
import com.example.aliments.modeles.Shop;

public class MenuDujour extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dujour);

        findViewById(R.id.buttonFactory1).setOnClickListener(click -> createAndDisplayItems1(new AbstractFactoryConserves())); //Conserves
        findViewById(R.id.buttonFactory2).setOnClickListener(click -> createAndDisplayItems1(new AbstractFactoryFrais()));
    }
    private void createAndDisplayItems1(AlimentAbstractFactory factory) {
        Aliments aliment = null;
        Shop shop = null;
        RadioGroup rgAliment = findViewById(R.id.radioGroupAliment);
        RadioGroup rgShop = findViewById(R.id.radioGroupSHOP);
        //todo use dimens instead of strings.xml in activity_main.xml
        int typeAliment = Integer.parseInt(findViewById(rgAliment.getCheckedRadioButtonId()).getTag() + "");
        int typeShop = Integer.parseInt(findViewById(rgShop.getCheckedRadioButtonId()).getTag() + "");
        try {
            aliment = factory.buildAliment(typeAliment);
            shop = factory.buildShop(typeShop);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (aliment != null && shop != null) {
            changePicture(aliment);
            changePicture(shop);
        } else {
            Toast.makeText(getApplicationContext(), "Impossible to build!", Toast.LENGTH_LONG).show();
            findViewById(R.id.imageResultShop).setVisibility(View.INVISIBLE);
            findViewById(R.id.imageResultAliment).setVisibility(View.INVISIBLE);

        }
    }
    private void changePicture(Aliments aliment) {

        int resourceNumPicture = getApplicationContext().getResources().getIdentifier(
                "conserve" + aliment.getNumIm(),
                "drawable",
                getApplicationContext().getPackageName());
        findViewById(R.id.imageResultAliment).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.imageResultAliment)).setImageResource(resourceNumPicture);
    }

    private void changePicture(Shop shop) {

        int resourceNumPicture = getApplicationContext().getResources().getIdentifier(
                "shop" + shop.getNumImage(),
                "drawable",
                getApplicationContext().getPackageName());
        findViewById(R.id.imageResultShop).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.imageResultShop)).setImageResource(resourceNumPicture);
    }
}