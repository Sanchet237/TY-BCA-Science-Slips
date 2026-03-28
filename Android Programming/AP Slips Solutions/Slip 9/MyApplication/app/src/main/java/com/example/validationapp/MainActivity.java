package com.example.validationapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);

        b1.setOnClickListener(v -> {

            String s1 = e1.getText().toString();
            String s2 = e2.getText().toString();

            if (s1.isEmpty() || s2.isEmpty()) {
                t1.setText("Enter both numbers");
                return;
            }

            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);

            if (n1 > 10 && n2 > 10) {
                t1.setText("Both numbers > 10. Enter new numbers!");
                e1.setText("");
                e2.setText("");
            } else {
                t1.setText("Number 1 = " + n1 + "\nNumber 2 = " + n2);
            }
        });
    }
}