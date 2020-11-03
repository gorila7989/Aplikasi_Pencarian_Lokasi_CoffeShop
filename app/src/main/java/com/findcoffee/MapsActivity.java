package com.findcoffee;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();
    }
    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(), currentLocation.getLatitude() + "" + currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMap);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(MapsActivity.this);
                }
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.navigation);
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.drawable.iconlokasicafe);

        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("I am here!").icon(icon);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13.0f));
        googleMap.addMarker(markerOptions);

        LatLng fika = new LatLng(-6.177977, 106.632445);
        googleMap.addMarker(new MarkerOptions().position(fika).title("Fika Kedai Kafi").icon(icon2));

        LatLng greetings = new LatLng(-6.191535, 106.671329);
        googleMap.addMarker(new MarkerOptions().position(greetings).title("Greetings Coffee").icon(icon2));

        LatLng kopiberkata = new LatLng(-6.168301, 106.631057);
        googleMap.addMarker(new MarkerOptions().position(kopiberkata).title("Kopi Berkata").icon(icon2));

        LatLng kopimumana = new LatLng(-6.181643, 106.630490);
        googleMap.addMarker(new MarkerOptions().position(kopimumana).title("Kopimumana Coffee Shop").icon(icon2));

        LatLng limkopi = new LatLng(-6.179882, 106.638249);
        googleMap.addMarker(new MarkerOptions().position(limkopi).title("Lim Kopi Coffee").icon(icon2));

        LatLng parislyon = new LatLng(-6.174190, 106.657380);
        googleMap.addMarker(new MarkerOptions().position(parislyon).title("Paris-Lyon Cafe").icon(icon2));

        LatLng pkp = new LatLng(-6.181920, 106.660902);
        googleMap.addMarker(new MarkerOptions().position(pkp).title("PKP Coffee").icon(icon2));

        LatLng qahwa = new LatLng(-6.187047, 106.659963);
        googleMap.addMarker(new MarkerOptions().position(qahwa).title("Qahwa Kedai Kopi").icon(icon2));

        LatLng tekofio = new LatLng(-6.190892, 106.657302);
        googleMap.addMarker(new MarkerOptions().position(tekofio).title("Tekofio Coffee").icon(icon2));

        LatLng xy = new LatLng(-6.177906, 106.632275);
        googleMap.addMarker(new MarkerOptions().position(xy).title("Xy Coffee & Roastery").icon(icon2));

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                }
                break;
        }
    }
}