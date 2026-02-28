package com.example.intentdemo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    TextView tvProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvProfile = findViewById(R.id.tvProfile);

        String profile =
                "Name: " + getIntent().getStringExtra("name") + "\n\n" +
                        "Date of Birth: " + getIntent().getStringExtra("dob") + "\n\n" +
                        "Gender: " + getIntent().getStringExtra("gender") + "\n\n" +
                        "Address: " + getIntent().getStringExtra("address") + "\n\n" +
                        "Contact: " + getIntent().getStringExtra("contact");

        tvProfile.setText(profile);
    }
}