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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliments.R;

public class SearchAlimentActivity extends AppCompatActivity {
    ListView ls;
    String mName[] = {"Banane" , "Pomme" , "Kiwi"};
    String mDescription[] = {"5 euros/kg" , "4 euros/kg" , "3 euros/kg" };
    int images[] = {R.drawable.bannane , R.drawable.pomme , R.drawable.kiwi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_aliment);
        ls = findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this , mName , mDescription , images );
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(SearchAlimentActivity.this, "5 euros/kg", Toast.LENGTH_SHORT).show();
                }if(position == 1){
                    Toast.makeText(SearchAlimentActivity.this, "4 euros/kg", Toast.LENGTH_SHORT).show();
                }if(position == 2){
                    Toast.makeText(SearchAlimentActivity.this, "3 euros/kg", Toast.LENGTH_SHORT).show();
                }
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
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rName[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c , String name[] , String description[] , int img[]){
            super(c , R.layout.row , R.id.textview1 , name );
            this.context = c;
            this.rName = name;
            this.rDescription = description;
            this.rImgs = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row , parent , false);
            ImageView images = row.findViewById(R.id.image);
            TextView name = row.findViewById(R.id.textview1);
            TextView description = row.findViewById(R.id.textview2);

            images.setImageResource(rImgs[position]);
            name.setText(rName[position]);
            description.setText(rDescription[position]);

            return row;
        }
    }
}
