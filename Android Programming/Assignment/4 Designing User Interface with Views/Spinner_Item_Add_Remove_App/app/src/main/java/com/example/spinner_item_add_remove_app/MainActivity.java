package com.example.spinner_item_add_remove_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editItem;
    Button btnAdd, btnRemove;
    Spinner spinner;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editItem = findViewById(R.id.editItem);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        spinner = findViewById(R.id.spinner);

        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, list);

        spinner.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {

            String item = editItem.getText().toString();

            if(!item.isEmpty()) {
                list.add(item);
                adapter.notifyDataSetChanged();
                editItem.setText("");
            }
        });

        btnRemove.setOnClickListener(v -> {

            if(list.size() > 0) {
                int position = spinner.getSelectedItemPosition();
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}