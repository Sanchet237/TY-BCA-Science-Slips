package com.example.studentform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etFirstName, etMiddleName, etLastName, etDOB, etAddress, etEmail;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstName);
        etMiddleName = findViewById(R.id.etMiddleName);
        etLastName = findViewById(R.id.etLastName);
        etDOB = findViewById(R.id.etDOB);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("first", etFirstName.getText().toString());
            intent.putExtra("middle", etMiddleName.getText().toString());
            intent.putExtra("last", etLastName.getText().toString());
            intent.putExtra("dob", etDOB.getText().toString());
            intent.putExtra("address", etAddress.getText().toString());
            intent.putExtra("email", etEmail.getText().toString());

            startActivity(intent);
        });
    }
}