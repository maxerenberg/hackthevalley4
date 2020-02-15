package com.hackthevalley4.hackthevalleyiv.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hackthevalley4.hackthevalleyiv.R;

public class SplitMapTest extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_map_test);

        recyclerView = findViewById(R.id.eventRecyclerView);
    }
}
