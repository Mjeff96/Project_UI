/*package com.example.matt.project_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText Email = (EditText) findViewById(R.id.EmailEntry);
        final EditText Password = (EditText) findViewById(R.id.PasswordEntry);

        final Button LoginBtn = (Button) findViewById(R.id.LoginBtn);
        final Button RegisterLink = (Button) findViewById(R.id.RegisterBtn);

        RegisterLink.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_register(v);
            }
        });

        setTitle("Login");
    }

    public void next_page_register(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
*/
package com.example.matt.project_ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final List<String> EmailUsers = Arrays.asList("calebvh@gmail.com", "jeffers@gmail.com");
        final List<String> Passwords = Arrays.asList("1234","5678");
        //Register Button
        Button registerButton = (Button) findViewById(R.id.NewUserBtn);
        registerButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                next_page_register(v);
            }
        });

        Button loginButton = (Button) findViewById(R.id.LoginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button loginButton = (Button) findViewById(R.id.LoginBtn);
                EditText Email = (EditText) findViewById(R.id.EmailEntry);
                EditText Password = (EditText) findViewById(R.id.PasswordEntry);
                String Email_entry = Email.getText().toString();
                String Password_entry = Password.getText().toString();
                if(EmailUsers.get(0).equals(Email_entry) && Passwords.get(0).equals(Password_entry)){
                    next_page_account(v);
                }
                else{
                    TextView ErrorNotif = (TextView) findViewById(R.id.Incorrect_textView5);
                    ErrorNotif.setVisibility(View.VISIBLE);
                }


            }
        });

        setTitle("My Account");
    }

    public void next_page_register(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void next_page_account(View v) {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }



}