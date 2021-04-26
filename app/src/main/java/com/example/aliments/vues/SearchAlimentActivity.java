package com.example.aliments.vues;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;
import com.example.aliments.adapters.MyAlimentAdapter;

public class SearchAlimentActivity extends AppCompatActivity {
    GridView gv;
    String[] name = {"Banane" , "Pomme" , "Kiwi","Orange","Fraise","Mango","Citron", "cerise" , "raison rouge","raisin jaune","grenade","pastèque", "cerise" , "raison rouge","raisin jaune","grenade","pastèque"};
    int [] imgs = {R.drawable.banane, R.drawable.pomme , R.drawable.kiwi,R.drawable.orange, R.drawable.fraise, R.drawable.mango, R.drawable.lemon,
            R.drawable.cherry , R.drawable.grape,R.drawable.grape1, R.drawable.grenade, R.drawable.pasteque,R.drawable.cherry , R.drawable.grape,R.drawable.grape1, R.drawable.grenade, R.drawable.pasteque};
    String mDescription[] = {"5 euros/kg" , "4 euros/kg" , "3 euros/kg", "2 euros/kg", "1 euros/kg" ,"1 euros/kg","1 euros/kg",
            "3 euros/kg", "2 euros/kg", "1 euros/kg" ,"1 euros/kg","1 euros/kg","3 euros/kg", "2 euros/kg", "1 euros/kg" ,"1 euros/kg","1 euros/kg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_aliment);

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
