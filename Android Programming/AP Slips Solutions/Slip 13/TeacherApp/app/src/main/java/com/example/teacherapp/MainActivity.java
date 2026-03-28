package com.example.teacherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText fname, mname, lname, dob, address, mobile, specialization;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.fname);
        mname = findViewById(R.id.mname);
        lname = findViewById(R.id.lname);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.address);
        mobile = findViewById(R.id.mobile);
        specialization = findViewById(R.id.specialization);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);

                i.putExtra("fname", fname.getText().toString());
                i.putExtra("mname", mname.getText().toString());
                i.putExtra("lname", lname.getText().toString());
                i.putExtra("dob", dob.getText().toString());
                i.putExtra("address", address.getText().toString());
                i.putExtra("mobile", mobile.getText().toString());
                i.putExtra("spec", specialization.getText().toString());

                startActivity(i);
            }
        });
    }
}