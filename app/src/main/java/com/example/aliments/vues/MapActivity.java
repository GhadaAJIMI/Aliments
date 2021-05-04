 package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aliments.R;

import org.osmdroid.api.IMapController;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

//43.65000, 7.01000
public class MapActivity extends AppCompatActivity {
    private MapView  map;

    int nbMagasins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nbMagasins = 1;
        Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.activity_map);
        map = findViewById(R.id.mapVendeur);
        map.setTileSource(TileSourceFactory.MAPNIK); // render
        map.setBuiltInZoomControls(true);           // zoomable
        GeoPoint startPoint = new GeoPoint(43.65020, 7.00517);
        IMapController mapController;
        mapController = map.getController();
        mapController.setCenter(startPoint);        // definir point de départ
        mapController.setZoom(18.0);                // Définir zoom de départ

        ArrayList<OverlayItem> magasins = new ArrayList<>();
        createmarker(43.65020, 7.00517);
        createmarker(43.64950, 7.00515);

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getApplicationContext(),
                magasins, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        });
        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);

        TextView addressLat = (TextView) findViewById(R.id.addressLatitude);
        TextView addressLong = (TextView) findViewById(R.id.addressLongitude);

        Button addressButton = (Button) findViewById(R.id.btnGetLocation);
        addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Double lat =  Double.valueOf(addressLat.getText().toString());
                Double longi = Double.valueOf(addressLong.getText().toString());

                createmarker(lat, longi);
            }
        });

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, AcceuilVendeurActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
        map.onPause();
    }
    @Override
    public void onResume(){
        super.onResume();
        map.onResume();
    }

    public void createmarker(Double latitude, Double longitude){
        if(map == null) {
            return;
        }
        Marker my_marker = new Marker(map);
        my_marker.setPosition(new GeoPoint(latitude, longitude));
        my_marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        my_marker.setTitle("Shop "+nbMagasins);
        nbMagasins = nbMagasins+1;
        my_marker.setPanToView(true);
        map.getOverlays().add(my_marker);
        map.invalidate();
    }
}

