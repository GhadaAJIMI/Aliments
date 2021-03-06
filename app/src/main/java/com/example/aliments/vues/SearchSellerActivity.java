package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.example.aliments.R;
import com.example.aliments.adapters.ListeMagasinsAdapter;
import com.example.aliments.controleurs.MagasinControler;
import com.example.aliments.modeles.Magasin;

import java.util.ArrayList;
import java.util.List;

public class SearchSellerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_seller);

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchSellerActivity.this, AcceuilAcheteurActivity.class);
                startActivity(intent);
            }
        });

        GridView shopListView = findViewById(R.id.shop_list_view);
        shopListView.setAdapter(new ListeMagasinsAdapter(this, MagasinControler.getListeMagasins()));
    }
}