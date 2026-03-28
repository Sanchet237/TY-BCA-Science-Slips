package com.example.loginvalidationwithemailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(v -> {

            String userEmail = email.getText().toString();
            String pass = password.getText().toString();

            if(userEmail.isEmpty() || pass.isEmpty())
            {
                Toast.makeText(this,"Enter all fields",Toast.LENGTH_SHORT).show();
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
            {
                Toast.makeText(this,"Invalid Email",Toast.LENGTH_SHORT).show();
            }
            else if(pass.length() < 4)
            {
                Toast.makeText(this,"Password must be 4 characters",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("message/rfc822");

                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{userEmail});

                intent.putExtra(Intent.EXTRA_SUBJECT,
                        "Login Successful");

                intent.putExtra(Intent.EXTRA_TEXT,
                        "Hello,\nYou have successfully logged in to the Android App.");

                startActivity(Intent.createChooser(intent,"Send Email"));
            }
        });
    }
}