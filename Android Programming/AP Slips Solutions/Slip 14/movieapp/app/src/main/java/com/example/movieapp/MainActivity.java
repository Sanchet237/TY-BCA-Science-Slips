package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, year, collection;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        year = findViewById(R.id.year);
        collection = findViewById(R.id.collection);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this, SecondActivity.class);

            i.putExtra("name", name.getText().toString());
            i.putExtra("year", year.getText().toString());
            i.putExtra("collection", collection.getText().toString());

            startActivity(i);
        });
    }
}