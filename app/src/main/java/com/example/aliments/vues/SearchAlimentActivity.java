package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.example.aliments.R;
import com.example.aliments.adapters.MyAlimentAdapter;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.MagasinControler;
import com.example.aliments.controleurs.UserControler;

public class SearchAlimentActivity extends AppCompatActivity {
    GridView gv;
    String[] name = new String[AlimentControler.listLenght()];
    int[] imgs = new int[AlimentControler.listLenght()];
    String[] mDescription = new String[AlimentControler.listLenght()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_aliment);

        for(int i = 0; i < AlimentControler.listLenght(); i++){
            name[i] = AlimentControler.get(i).getName();
            imgs[i] = this.getResources().getIdentifier(AlimentControler.get(i).getMnemonic(), "drawable", this.getPackageName());
            mDescription[i] = AlimentControler.get(i).getPrix()+" €/kg";
        }

        gv = findViewById(R.id.gridview);
        MyAlimentAdapter adapter = new MyAlimentAdapter(SearchAlimentActivity.this , name , imgs, mDescription);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Ajouter l'aliment dans le panier de l'utilisateur
                if(UserControler.get(0).getBasket().contains(AlimentControler.get(position))){
                    UserControler.get(0).getBasket().add(AlimentControler.get(position), 1.0);
                }
                else
                {
                    UserControler.get(0).getBasket().add(AlimentControler.get(position));
                }
                Toast.makeText(SearchAlimentActivity.this, AlimentControler.get(position).getName()+" est ajouté au panier", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById( R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchAlimentActivity.this, AcceuilAcheteurActivity.class);
                startActivity(intent);
            }
        });
    }
}
