package com.example.aliments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.aliments.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAlimentAdapter extends ArrayAdapter<String> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private String[] name;
    private String[] prix;
    private int[] imgs;

    public MyAlimentAdapter(Context c , String[] name , int[] imgs, String[] prix) {
        super(c , R.layout.row , R.id.nameview , name );
        context = c;
        this.imgs  = imgs;
        this.name = name;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.prix = prix;
    }
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.row , parent , false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.nameview);
        TextView textView1 = convertView.findViewById(R.id.priceview);
        imageView.setImageResource(imgs[position]);
        textView.setText(name[position]);
        textView1.setText(prix[position]);
        return convertView;
    }
}


