package com.example.matt.project_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;

import java.util.ArrayList;

public class UsersCatalog extends AppCompatActivity {
    RecyclerView catalog_view;
    CatalogItemAdapter catalog_adapter;
    ArrayList<CatalogItem> catalog_items;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_catalog);

        DatabaseManager db = new DatabaseManager(getApplicationContext());

        setTitle("Your Catalog");

        catalog_items = (ArrayList)DataSource.createListItems(db);
        catalog_adapter = new CatalogItemAdapter(catalog_items);

        catalog_view = (RecyclerView)findViewById(R.id.recycler_view);
        catalog_view.setLayoutManager(new LinearLayoutManager(this));
        catalog_view.setItemAnimator(new DefaultItemAnimator());
        catalog_view.setAdapter(catalog_adapter);


    }

    public void next_page_home(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void next_page_myaccount(View v) {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void next_page_settings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }


}
