package com.example.fontchanger;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnSize, btnColor, btnFont;
    int size = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnSize = findViewById(R.id.btnSize);
        btnColor = findViewById(R.id.btnColor);
        btnFont = findViewById(R.id.btnFont);

        // Change Size
        btnSize.setOnClickListener(v -> {
            size += 5;
            textView.setTextSize(size);
        });

        // Change Color
        btnColor.setOnClickListener(v ->
                textView.setTextColor(Color.RED)
        );

        // Change Font
        btnFont.setOnClickListener(v ->
                textView.setTypeface(Typeface.MONOSPACE)
        );
    }
}