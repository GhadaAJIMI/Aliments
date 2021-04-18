package com.example.aliments.vues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.aliments.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {
    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        OverlayItem shop1 = new OverlayItem("shop1", "Magasin de légumes", new GeoPoint(43.65020, 7.00517));
        Drawable m = shop1.getMarker(0);
        magasins.add(shop1);
        OverlayItem shop2 = new OverlayItem("shop2", "Boucherie", new GeoPoint(43.64950, 7.00515));
        magasins.add(shop2);

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
}