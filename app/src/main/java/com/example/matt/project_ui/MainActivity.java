package com.example.matt.project_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Catalog Button
        Button CatalogButton = (Button) findViewById(R.id.CatalogButton);
        CatalogButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_catalog(v);
            }
        });

        //Account Button
        Button AccountButton = (Button) findViewById(R.id.AccountButton);
        AccountButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_myaccount(v);
            }
        });


        //Settings Button
        Button settingsButton = (Button) findViewById(R.id.SettingsButton);
        settingsButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_settings(v);
            }
        });

        setTitle("Workout App");
    }

    // Navigation Bar Button Definitions
    //////////////////////////////////////////////////////////////////////////////
    public void next_page_catalog(View v) {
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivity(intent);
    }

    public void next_page_myaccount(View v) { //Should be Account Activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void next_page_settings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    //////////////////////////////////////////////////////////////////////////////////
}