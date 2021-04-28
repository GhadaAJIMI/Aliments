package com.example.aliments.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aliments.R;
import com.example.aliments.modeles.Magasin;

import java.util.List;

public class ListeMagasinsAdapter extends BaseAdapter {

    private Context context;
    private List<Magasin> listeMagasins;
    private LayoutInflater inflater;

    public ListeMagasinsAdapter(Context context, List<Magasin> listeMagasins) {
        this.context = context;
        this.listeMagasins = listeMagasins;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listeMagasins.size();
    }

    @Override
    public Magasin getItem(int position) {
        return listeMagasins.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = this.inflater.inflate(R.layout.adapter_magasin, null);

        Magasin currentMagasin = getItem(position);
        String nameMagasin = currentMagasin.getName();
        String mnemonic = currentMagasin.getMnemonic();
        String numTel = currentMagasin.getNumeroTelephone();

        ImageView shopIconView = convertView.findViewById(R.id.shop_icon);
        String resourceName = "shop_"+mnemonic+"_icon";
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        shopIconView.setImageResource(resId);

        TextView shopNameView = convertView.findViewById(R.id.shop_name);
        shopNameView.setText(nameMagasin);

        TextView shopNumView = convertView.findViewById(R.id.shop_numTel);
        shopNumView.setText("N° de tél: "+numTel+"");

        Button appeler =(Button) convertView.findViewById(R.id.appeler);

        appeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ( currentMagasin.getNumeroTelephone())));
                context.startActivity(appel);
            }
        });

        return convertView;
    }
}
