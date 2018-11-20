package com.example.matt.project_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsersCatalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_catalog);

        DatabaseManager db = new DatabaseManager(getApplicationContext());

        db.getColumnData("name", "Arms");
        setTitle("Your Catalog");
    }
}
