package com.example.datewiseimagedisplay;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        imageView = findViewById(R.id.imageView);

        datePicker.setOnDateChangedListener((view, year, month, dayOfMonth) -> {

            if(dayOfMonth == 1)
                imageView.setImageResource(R.drawable.img1);

            else if(dayOfMonth == 2)
                imageView.setImageResource(R.drawable.img2);

            else if(dayOfMonth == 3)
                imageView.setImageResource(R.drawable.img3);

            else
                imageView.setImageResource(R.drawable.img4);

        });
    }
}