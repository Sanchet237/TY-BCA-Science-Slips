package com.example.callapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(v -> {

            String number = e1.getText().toString();

            if (number.isEmpty()) {
                Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + number));

            startActivity(i);
        });
    }
}