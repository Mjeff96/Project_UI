package com.example.matt.project_ui;

import android.content.Context;
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

        ArrayList<CheckBox> checkboxes = new ArrayList<CheckBox>();

        ArrayList<String> option_list =new ArrayList<String>();
        option_list.add("Abs");
        option_list.add("Arms");
        option_list.add("Back");
        option_list.add("Calisthenics");
        option_list.add("Cardio");
        option_list.add("Calves");
        option_list.add("Legs");
        option_list.add("Pilottes");
        option_list.add("Yoga");

        checkboxes = setup_table(option_list);

        final ArrayList<CheckBox> checked_boxes = checkboxes;
        final ArrayList<String> optionnames = option_list;

        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page(v, checked_boxes, optionnames);
            }
        });

        setTitle("Catalogs");
    }

    public void next_page(View v, ArrayList<CheckBox> boxes, ArrayList<String> catalogoptions) {
        Intent intent;

        populate_catalog(boxes, catalogoptions);

        intent = new Intent(this, UsersCatalog.class);

        startActivity(intent);
    }


    public ArrayList<CheckBox> setup_table(ArrayList<String> data){
        ArrayList<CheckBox> checkboxes = new ArrayList<CheckBox>();

        for(int i = 0; i < data.size(); i++){
            TableLayout tl=(TableLayout)findViewById(R.id.catalog_options);
            TableRow tr1 = new TableRow(this);
            tr1.setLayoutParams(new TableRow.LayoutParams( TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
            CheckBox Box= new CheckBox(this);
            checkboxes.add(Box);
            tr1.addView(Box);
            TextView textview = new TextView(this);
            textview.setText(data.get(i));
            tr1.addView(textview);
            textview.setTextColor(Color.BLACK);
            textview.setTextSize(30);
            tl.addView(tr1, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        }

        return checkboxes;
    }

    public void populate_catalog(ArrayList<CheckBox> checkboxes, ArrayList<String> catalogoptions){

        for(int i = 0; i < checkboxes.size(); i++){
            if(checkboxes.get(i).isChecked()){
                
            }
        }

    }
}
