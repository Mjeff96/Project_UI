package com.example.matt.project_ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Button homeButton = (Button) findViewById(R.id.homeButton);

        homeButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_home(v);
            }
        });


        setTitle("My Account");
    }

    public void next_page_home(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}