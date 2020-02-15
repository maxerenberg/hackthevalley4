package com.hackthevalley4.hackthevalleyiv.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.hackthevalley4.hackthevalleyiv.R;

public class AccountCreateActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText username;
    private EditText password;
    private EditText preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create);
        name = findViewById(R.id.createActName);
        email = findViewById(R.id.createActEmail);
        username = findViewById(R.id.createActUsername);
        password = findViewById(R.id.createActPassword);
        preferences = findViewById(R.id.createActPreferences);


    }
}
