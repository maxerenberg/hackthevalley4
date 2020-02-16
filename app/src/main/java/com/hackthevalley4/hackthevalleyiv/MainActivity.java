package com.hackthevalley4.hackthevalleyiv;

import android.content.Intent;
import android.os.Bundle;

import com.hackthevalley4.hackthevalleyiv.controller.AccountCreateActivity;
import com.hackthevalley4.hackthevalleyiv.controller.DashboardEventActivity;
import com.hackthevalley4.hackthevalleyiv.controller.SplitMapTest;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button createAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        login = findViewById(R.id.loginButton);
        createAct = findViewById(R.id.createActButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCorrect(username.getText().toString(), password.getText().toString()) ) {
                    startActivity(new Intent(MainActivity.this, SplitMapTest.class));
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                    //Toast.makeText(MainActivity.this, username.getText(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(MainActivity.this, password.getText(), Toast.LENGTH_LONG).show();
                }
            }
        });

        createAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AccountCreateActivity.class));
            }
        });


        }

    private boolean isCorrect(String username, String password) {
        return true;
        // TODO

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
