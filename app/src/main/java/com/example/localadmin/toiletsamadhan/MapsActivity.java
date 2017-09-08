package com.example.localadmin.toiletsamadhan;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double myLat, myLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        myLat = getIntent().getDoubleExtra("lat",0.0);
        myLng  = getIntent().getDoubleExtra("long",0.0);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Log.d("Latitude="+myLat,"Longitude="+myLng);
//        LatLng myLocation = new LatLng(12.925478, 77.6854875);
        LatLng myLocation = new LatLng(myLat, myLng);
        mMap.addMarker(new MarkerOptions().position(myLocation).title("I am here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(myLocation));
        Toast.makeText(this, myLat + " WORKS " + myLng + "", Toast.LENGTH_LONG).show();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(myLat,myLng), 6.0f));
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(12.925478, 77.6854875), 6.0f));
    }

}
