package com.example.movieapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        output = findViewById(R.id.output);

        String data =
                "Movie Name: " + getIntent().getStringExtra("name") + "\n" +
                        "Release Year: " + getIntent().getStringExtra("year") + "\n" +
                        "Collection: " + getIntent().getStringExtra("collection");

        output.setText(data);
    }
}