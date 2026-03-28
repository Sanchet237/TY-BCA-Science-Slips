package com.example.studentdb;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, phone;
    Button insert, show;
    TextView result;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);

        insert = findViewById(R.id.insert);
        show = findViewById(R.id.show);
        result = findViewById(R.id.result);

        db = new DBHelper(this);

        insert.setOnClickListener(v -> {
            db.insertData(
                    name.getText().toString(),
                    phone.getText().toString()
            );

            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
        });

        show.setOnClickListener(v -> {
            String data = db.getAllData();

            if (data.isEmpty()) {
                result.setText("No Records Found");
            } else {
                result.setText(data);
            }
        });
    }
}