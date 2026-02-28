package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnProfile = findViewById(R.id.btnProfile);

        btnProfile.setOnClickListener(v -> {

            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

            // Sending profile data
            intent.putExtra("name", "Sanchet Kolekar");
            intent.putExtra("dob", "23/07/2003");
            intent.putExtra("gender", "Male");
            intent.putExtra("address", "Pune");
            intent.putExtra("contact", "7066062254");

            startActivity(intent);
        });
    }
}