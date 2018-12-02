package com.example.matt.project_ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    RecyclerView catalog_view;
    CatalogOptionAdapter catalog_adapter;
    ArrayList<CatalogOption> catalog_options = new ArrayList<CatalogOption>();

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

        setTitle("Catalogs");

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

        for(int i=0;i<option_list.size(); i++){
            CatalogOption co = new CatalogOption();

            co.setOptionText(option_list.get(i));
            catalog_options.add(co);
        }

        catalog_adapter = new CatalogOptionAdapter(catalog_options);

        catalog_view = (RecyclerView)findViewById(R.id.recycler_view_options);
        catalog_view.setLayoutManager(new LinearLayoutManager(this));
        catalog_view.setItemAnimator(new DefaultItemAnimator());
        catalog_view.setAdapter(catalog_adapter);
    }

    public void next_page(View v) {
        Intent intent;

        intent = new Intent(this, UsersCatalog.class);

        startActivity(intent);
    }

}
