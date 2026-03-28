package com.example.progressbar;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    RadioButton r1, r2;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.rateInput);
        r1 = findViewById(R.id.yearlyToMonthly);
        r2 = findViewById(R.id.monthlyToYearly);
        b1 = findViewById(R.id.convertBtn);
        t1 = findViewById(R.id.resultText);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = e1.getText().toString();

                if (s.isEmpty()) {
                    t1.setText("Enter value");
                    return;
                }

                double rate = Double.parseDouble(s);
                double result;

                if (r1.isChecked()) {
                    result = rate / 12;
                } else {
                    result = rate * 12;
                }

                t1.setText("Result: " + result);
            }
        });
    }
}
