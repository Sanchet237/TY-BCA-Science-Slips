package com.example.checkboxapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox c1, c2, c3;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        b1 = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = "Selected: ";

                if (c1.isChecked()) result += "Java ";
                if (c2.isChecked()) result += "Python ";
                if (c3.isChecked()) result += "Android ";

                if (result.equals("Selected: ")) {
                    result = "Nothing selected";
                }

                t1.setText(result);
            }
        });
    }
}