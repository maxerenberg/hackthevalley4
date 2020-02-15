package com.hackthevalley4.hackthevalleyiv.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hackthevalley4.hackthevalleyiv.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.radar.sdk.Radar;
import io.radar.sdk.model.RadarEvent;
import io.radar.sdk.model.RadarGeofence;
import io.radar.sdk.model.RadarUser;

public class DashboardEventsActivity extends AppCompatActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Radar.initialize("prj_test_pk_f5ded24f4e726f8af453a6e52de4f28f67d6b34b");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_events);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        Radar.setUserId("fredId");
        Radar.setDescription("Test for Id");

        ActivityCompat.requestPermissions(DashboardEventsActivity.this, new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        Radar.trackOnce(new Radar.RadarCallback() {
            @Override
            public void onComplete(@NotNull Radar.RadarStatus radarStatus, @Nullable Location location, @Nullable RadarEvent[] radarEvents, @Nullable RadarUser radarUser) {
                if (radarUser != null) {
                    Log.i("owo", String.format("%s %s %s %s", radarStatus, location, radarEvents, radarUser));

                    boolean foundGeofence = false;
                    for (RadarGeofence geofence : radarUser.getGeofences()) {
                        if (geofence.getId().equals("5e47b2102ef44e02f2c26622")) {
                            foundGeofence = true;
                            Toast.makeText(DashboardEventsActivity.this, "In IC building", Toast.LENGTH_LONG).show();
                            break;

                        }
                    }
                    if (!foundGeofence) {
                        Toast.makeText(DashboardEventsActivity.this, "No events nearby", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(DashboardEventsActivity.this, "No user exist", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }



}

