package com.example.matt.project_ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button Register = (Button) findViewById(R.id.RegisterBtn);
        Register.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_account(v);
            }
        });


        setTitle("Register");
    }


    public void next_page_account(View v) {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

}
