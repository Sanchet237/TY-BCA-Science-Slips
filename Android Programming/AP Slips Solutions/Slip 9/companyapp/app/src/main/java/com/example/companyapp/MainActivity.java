package com.example.companyapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, address, phone;
    Button insert, view;
    TextView output;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        insert = findViewById(R.id.insert);
        view = findViewById(R.id.view);
        output = findViewById(R.id.output);

        db = new DBHelper(this);

        insert.setOnClickListener(v -> {
            db.insertData(
                    name.getText().toString(),
                    address.getText().toString(),
                    phone.getText().toString()
            );

            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
        });

        view.setOnClickListener(v -> {
            Cursor c = db.getData();

            String data = "";

            while (c.moveToNext()) {
                data += "ID: " + c.getInt(0) + "\n";
                data += "Name: " + c.getString(1) + "\n";
                data += "Address: " + c.getString(2) + "\n";
                data += "Phone: " + c.getString(3) + "\n\n";
            }

            if (data.equals("")) {
                output.setText("No Data Found");
            }

            output.setText(data);
        });
    }
}