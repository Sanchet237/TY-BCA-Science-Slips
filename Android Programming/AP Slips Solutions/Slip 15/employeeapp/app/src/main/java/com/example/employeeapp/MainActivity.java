package com.example.employeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText fname, mname, lname, salary, address, email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.fname);
        mname = findViewById(R.id.mname);
        lname = findViewById(R.id.lname);
        salary = findViewById(R.id.salary);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this, SecondActivity.class);

            i.putExtra("fname", fname.getText().toString());
            i.putExtra("mname", mname.getText().toString());
            i.putExtra("lname", lname.getText().toString());
            i.putExtra("salary", salary.getText().toString());
            i.putExtra("address", address.getText().toString());
            i.putExtra("email", email.getText().toString());

            startActivity(i);
        });
    }
}