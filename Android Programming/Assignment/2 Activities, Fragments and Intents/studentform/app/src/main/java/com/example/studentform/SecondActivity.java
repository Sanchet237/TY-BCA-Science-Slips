package com.example.studentform;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvDetails = findViewById(R.id.tvDetails);

        String details =
                "First Name: " + getIntent().getStringExtra("first") + "\n\n" +
                        "Middle Name: " + getIntent().getStringExtra("middle") + "\n\n" +
                        "Last Name: " + getIntent().getStringExtra("last") + "\n\n" +
                        "DOB: " + getIntent().getStringExtra("dob") + "\n\n" +
                        "Address: " + getIntent().getStringExtra("address") + "\n\n" +
                        "Email: " + getIntent().getStringExtra("email");

        tvDetails.setText(details);
    }
}