package com.example.teacherapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t = findViewById(R.id.t1);

        String data =
                "First Name: " + getIntent().getStringExtra("fname") + "\n" +
                        "Middle Name: " + getIntent().getStringExtra("mname") + "\n" +
                        "Last Name: " + getIntent().getStringExtra("lname") + "\n" +
                        "DOB: " + getIntent().getStringExtra("dob") + "\n" +
                        "Address: " + getIntent().getStringExtra("address") + "\n" +
                        "Mobile: " + getIntent().getStringExtra("mobile") + "\n" +
                        "Specialization: " + getIntent().getStringExtra("spec");

        t.setText(data);
    }
}