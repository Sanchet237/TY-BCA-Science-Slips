package com.example.evenodd;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        b1 = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = e1.getText().toString();

                if (s.length() == 0) {
                    t1.setText("Enter a number");
                    return;
                }

                int num = Integer.parseInt(s);

                if (num % 2 == 0) {
                    t1.setText("Even Number");
                } else {
                    t1.setText("Odd Number");
                }
            }
        });
    }
}