package com.example.matt.project_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CatalogActivity extends AppCompatActivity {


    Spinner dropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);


        String[] items = new String[]{"Arms", "Legs", "Yoga"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown = findViewById(R.id.spinner);
        dropdown.setAdapter(adapter);


        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page(v);
            }
        });

        setTitle("Catalogs");
    }

    public void next_page(View v) {
        String text = dropdown.getSelectedItem().toString();
        Intent intent;

        intent = new Intent(this, UsersCatalog.class);

        startActivity(intent);
    }
}
