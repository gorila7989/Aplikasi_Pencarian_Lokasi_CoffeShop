package com.findcoffee.mapscoffee;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.findcoffee.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsParislyon extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_parislyon);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.drawable.iconlokasicafe);
        // Add a marker and move the camera
        LatLng parislyon = new LatLng(-6.174190, 106.657380);
        mMap.addMarker(new MarkerOptions().position(parislyon).title("Paris-Lyon Cafe").icon(icon2));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(parislyon, 17),7000, null);
    }
}