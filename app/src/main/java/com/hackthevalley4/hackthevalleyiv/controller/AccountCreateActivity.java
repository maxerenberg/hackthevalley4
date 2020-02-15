package com.hackthevalley4.hackthevalleyiv.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hackthevalley4.hackthevalleyiv.MainActivity;
import com.hackthevalley4.hackthevalleyiv.R;

public class AccountCreateActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText username;
    private EditText password;
    private EditText preferences;

    private Button createAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create);
        name = findViewById(R.id.createActName);
        email = findViewById(R.id.createActEmail);
        username = findViewById(R.id.createActUsername);
        password = findViewById(R.id.createActPassword);
        preferences = findViewById(R.id.createActPreferences);

        createAccountButton = findViewById(R.id.makeActButton);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giveData(name.getText().toString(), email.getText().toString(), username.getText().toString(), password.getText().toString(), preferences.getText().toString());
                startActivity(new Intent(AccountCreateActivity.this, MainActivity.class));
            }
        });
    }

    private void giveData(String toString, String toString1, String toString2, String toString3, String toString4) {
        // TODO: implement Mongo 
    }
}
