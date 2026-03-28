package com.example.switchtoggle;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Switch sw;
    ToggleButton tb;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = findViewById(R.id.switch1);
        tb = findViewById(R.id.toggle1);
        result = findViewById(R.id.result);

        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                result.setText("Switch is ON");
            else
                result.setText("Switch is OFF");
        });

        tb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                result.setText("Toggle Button is ON");
            else
                result.setText("Toggle Button is OFF");
        });
    }
}