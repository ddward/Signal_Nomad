package com.example.david.myapplication;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    //DW: Allow global access to the database, map, and user list
    AppDatabase db_master;
    private GoogleMap mMap;
    List<User> u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DW: Initialize an instance of the database
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
                db_master = db;

        //DW: Pull previously existing markers into a list variable asynchronously
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<User> users = db_master.userDao().getAll();
                //DW: Populate the global variable
                u = users;
            }
        }).start();

        setContentView(R.layout.activity_maps);
        //Google: Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        try {
            mMap.setMyLocationEnabled(true);
        } catch (SecurityException e) {
            Log.d("Location Services: ", "Disabled");
        }

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        //DW: Loop through the list of users and drop a pin at the latitudes and longitude of every row along with the network strength recorded at that location
        for(int i = 0; i < u.size(); i++) {
                    LatLng ll = new LatLng(u.get(i).Latitude, u.get(i).Longitude);
                    mMap.addMarker(new MarkerOptions().position(ll).title(u.get(i).Signal_Strength));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
                }
    }

    //DW: Necessary to use current location indicator on google maps
    @Override
    public void onMyLocationClick(@NonNull Location location) {
    }

    //DW: Necessary to use current location indicator on google maps
    @Override
    public boolean onMyLocationButtonClick() {
        //Google: Return false so that we don't consume the event and the default behavior still occurs
        //Google: (the camera animates to the user's current position).
        return false;
    }

    //Function to remove all markers from the view, called by button click
    public void clearmarkers(View view){
        mMap.clear();
    }

    //DW: Function to drop a pin, called by button click
    public void pindrop(View view) {
        //initializing a new instance of LocationManager
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = null;
        String signal = null;

        //DW: Gather location data, return an exception if location services are off
        try {
            location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Signal_Catcher s = new Signal_Catcher();
            signal = s.getNetworkClass(this);

        } catch (SecurityException e) {
            Log.d("Location Services", "Disabled");
        }

        final double longitude = location.getLongitude();
        final double latitude = location.getLatitude();
        final String s = signal;

        Log.d("latitude", "lat: " + latitude);
        Log.d("longitude", "long: " + longitude);
        Log.d("signal", "strength = " + signal);

        //Drop a new marker on the map at the new lat/long and network strength
        LatLng ll = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(ll).title(s));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));

        //Store the new lat/long and network strength in the database
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                user.Latitude = latitude;
                user.Longitude = longitude;
                user.Signal_Strength = s;
                db_master.userDao().insertAll(user);
                Log.d("Database row count","" +  db_master.userDao().getAll().size());
            }
        }).start();
    }
}
