package com.example.spinnerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button add, remove;
    Spinner spinner;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        add = findViewById(R.id.add);
        remove = findViewById(R.id.remove);
        spinner = findViewById(R.id.spinner);

        list = new ArrayList<>();
        list.add("Apple"); // default item

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        add.setOnClickListener(v -> {
            String item = e1.getText().toString();

            if (!item.isEmpty()) {
                list.add(item);
                adapter.notifyDataSetChanged();
                e1.setText("");
            }
        });

        remove.setOnClickListener(v -> {
            if (!list.isEmpty()) {
                String selected = spinner.getSelectedItem().toString();
                list.remove(selected);
                adapter.notifyDataSetChanged();
            }
        });
    }
}