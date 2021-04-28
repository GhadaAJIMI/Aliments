package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aliments.R;
import com.example.aliments.controleurs.AlimentControler;

public class ConsulterAlimentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_aliment);

        ImageView imageView = findViewById(R.id.aliment_icon);
        TextView name = findViewById(R.id.aliment_name2);
        TextView price = findViewById(R.id.aliment_price2);

        imageView.setImageResource(AlimentControler.aliment.getRsc());
        name.setText(AlimentControler.aliment.getName());
        price.setText(AlimentControler.aliment.getPrix()+" €");

        AlimentControler.aliment = null;

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsulterAlimentActivity.this, SearchAlimentActivity.class);
                startActivity(intent);
            }
        });
    }
}