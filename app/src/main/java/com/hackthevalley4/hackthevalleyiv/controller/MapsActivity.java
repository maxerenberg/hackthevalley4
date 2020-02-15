package com.hackthevalley4.hackthevalleyiv.controller;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hackthevalley4.hackthevalleyiv.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.radar.sdk.Radar;
import io.radar.sdk.model.RadarEvent;
import io.radar.sdk.model.RadarUser;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Radar.initialize("prj_test_pk_f5ded24f4e726f8af453a6e52de4f28f67d6b34b");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Radar.setUserId("htvRadarId");
        Radar.setDescription("Radar.io");

        ActivityCompat.requestPermissions(MapsActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        if (ContextCompat.checkSelfPermission(MapsActivity.this, permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[] {permission.ACCESS_FINE_LOCATION},
                    0);
        }

        Radar.trackOnce(new Radar.RadarCallback() {
            @Override
            public void onComplete(@NotNull Radar.RadarStatus radarStatus, @Nullable Location location, @Nullable RadarEvent[] radarEvents, @Nullable RadarUser radarUser) {

            }
        });



    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
