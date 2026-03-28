package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView tvDetails;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvDetails = findViewById(R.id.t);
        btnBack = findViewById(R.id.backBtn);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String surname = intent.getStringExtra("surname");
            String sClass = intent.getStringExtra("class");
            String marks = intent.getStringExtra("marks");
            String gender = intent.getStringExtra("gender");
            String hobbies = intent.getStringExtra("hobbies");

            String displayData = String.format(
                    "Name: %s\n" +
                    "Surname: %s\n" +
                    "Class: %s\n" +
                    "Marks: %s\n" +
                    "Gender: %s\n" +
                    "Hobbies: %s",
                    name, surname, sClass, marks, gender, hobbies
            );

            tvDetails.setText(displayData);
        }

        btnBack.setOnClickListener(v -> finish());
    }
}