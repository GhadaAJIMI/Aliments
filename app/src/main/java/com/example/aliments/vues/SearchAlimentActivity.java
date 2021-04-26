package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.example.aliments.R;
import com.example.aliments.adapters.MyAlimentAdapter;
import com.example.aliments.controleurs.AlimentControler;
import com.example.aliments.controleurs.MagasinControler;

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
                if(position == 0){
                    Toast.makeText(SearchAlimentActivity.this, "5 euro/kg", Toast.LENGTH_SHORT).show();
                }if(position == 1){
                    Toast.makeText(SearchAlimentActivity.this, "4 euro/kg", Toast.LENGTH_SHORT).show();
                }if(position == 2){
                    Toast.makeText(SearchAlimentActivity.this, "3 euro/kg", Toast.LENGTH_SHORT).show();
                }if(position == 3){
                    Toast.makeText(SearchAlimentActivity.this, "2 euros/kg", Toast.LENGTH_SHORT).show();
                }if(position == 4) {
                    Toast.makeText(SearchAlimentActivity.this, "1 euros/kg", Toast.LENGTH_SHORT).show();
                }
            }
        });

     /*  findViewById( R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchAlimentActivity.this, AcceuilAcheteurActivity.class);
                startActivity(intent);
            }
        });
        
      */
    }
}
