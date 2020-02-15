package com.hackthevalley4.hackthevalleyiv.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;

import com.hackthevalley4.hackthevalleyiv.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.radar.sdk.Radar;
import io.radar.sdk.model.RadarEvent;
import io.radar.sdk.model.RadarUser;

public class DashboardEventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Radar.initialize("prj_test_pk_f5ded24f4e726f8af453a6e52de4f28f67d6b34b");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_events);

        Radar.setUserId("fredId");
        Radar.setDescription("Test for Id");

        ActivityCompat.requestPermissions(DashboardEventsActivity.this, new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        Radar.trackOnce(new Radar.RadarCallback() {
            @Override
            public void onComplete(@NotNull Radar.RadarStatus radarStatus, @Nullable Location location, @Nullable RadarEvent[] radarEvents, @Nullable RadarUser radarUser) {

            }
        });
    }




}

