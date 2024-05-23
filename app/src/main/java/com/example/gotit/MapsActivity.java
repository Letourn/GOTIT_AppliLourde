package com.example.gotit;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.gotit.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.gotit.databinding.ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng france = new LatLng(46.232193, 2.209667);
        googleMap.addMarker(new MarkerOptions().position(france).title("France"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(france));
        /**AppDatabase db = MainActivity.getDatabase();
         List<Lieux> lieux = db.LieuxDao().getAllLieux();
         for (Lieux element : lieux) {
            // LatLng permet de créer des variables contenant des coordonnées
            LatLng lieu = new LatLng(element.latitude, element.longitude);
            googleMap.addMarker(new MarkerOptions().position(lieu).title(element.nom));
        }*/



    }
}