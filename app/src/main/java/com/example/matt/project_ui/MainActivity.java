package com.example.matt.project_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page(v);
            }
        });

        setTitle("Workout App");
    }

    public void next_page(View v) {
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivity(intent);
    }
}