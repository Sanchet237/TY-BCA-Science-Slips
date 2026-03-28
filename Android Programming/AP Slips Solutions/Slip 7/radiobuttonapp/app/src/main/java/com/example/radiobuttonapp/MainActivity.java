package com.example.radiobuttonapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton r1, r2, r3;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        b1 = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);

        b1.setOnClickListener(v -> {

            String result = "";

            if (r1.isChecked()) result = "Selected: Java";
            else if (r2.isChecked()) result = "Selected: Python";
            else if (r3.isChecked()) result = "Selected: Android";
            else result = "Nothing selected";

            t1.setText(result);
        });
    }
}