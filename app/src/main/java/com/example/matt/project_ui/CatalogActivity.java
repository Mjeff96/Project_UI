package com.example.matt.project_ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class CatalogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page(v);
            }
        });

        ArrayList<String> option_list =new ArrayList<String>();
        option_list.add("Arms");
        option_list.add("Legs");
        option_list.add("Yoga");

        setup_table(option_list);
        setTitle("Catalogs");
    }

    public void next_page(View v) {
        Intent intent;

        intent = new Intent(this, UsersCatalog.class);

        startActivity(intent);
    }

    public void setup_table(ArrayList<String> data){
        for(int i = 0; i < data.size(); i++){
            TableLayout tl=(TableLayout)findViewById(R.id.catalog_options);
            TableRow tr1 = new TableRow(this);
            tr1.setLayoutParams(new TableRow.LayoutParams( TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
            CheckBox Box= new CheckBox(this);
            tr1.addView(Box);
            TextView textview = new TextView(this);
            textview.setText(data.get(i));
            tr1.addView(textview);
            textview.setTextColor(Color.BLACK);
            textview.setTextSize(30);
            tl.addView(tr1, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
}
