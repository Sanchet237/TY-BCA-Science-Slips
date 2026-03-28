package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {

            String e = email.getText().toString();
            String p = password.getText().toString();

            // Hardcoded credentials
            if (e.equals("admin@gmail.com") && p.equals("1234")) {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);

            } else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}