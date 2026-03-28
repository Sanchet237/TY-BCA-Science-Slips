package com.example.lightbulbtoggleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggle;
    ImageView bulb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = findViewById(R.id.toggleButton);
        bulb = findViewById(R.id.bulb);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    bulb.setImageResource(R.drawable.bulb_on);
                }
                else
                {
                    bulb.setImageResource(R.drawable.bulb_off);
                }
            }
        });
    }
}