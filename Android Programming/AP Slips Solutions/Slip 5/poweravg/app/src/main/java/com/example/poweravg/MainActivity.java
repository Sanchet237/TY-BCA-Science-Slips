package com.example.poweravg;

import android.os.Bundle;
import android.view.View;
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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                if (s1.isEmpty() || s2.isEmpty()) {
                    t1.setText("Enter both numbers");
                    return;
                }

                double a = Double.parseDouble(s1);
                double b = Double.parseDouble(s2);

                double power = Math.pow(a, b);
                double avg = (a + b) / 2;

                t1.setText("Power = " + power + "\nAverage = " + avg);
            }
        });
    }
}