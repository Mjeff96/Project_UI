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

        Button CatalogButton = (Button) findViewById(R.id.CatalogButton);

        CatalogButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_catalog(v);
            }
        });

        Button AccountButton = (Button) findViewById(R.id.AccountButton);

        AccountButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_myaccount(v);
            }
        });

        setTitle("Workout App");
    }

    public void next_page_catalog(View v) {
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivity(intent);
    }

    public void next_page_myaccount(View v) {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }
}