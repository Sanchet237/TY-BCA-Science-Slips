package com.example.fileexplorerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        File directory = Environment.getExternalStorageDirectory();
        File[] files = directory.listFiles();

        ArrayList<String> fileNames = new ArrayList<>();

        for(File file : files)
        {
            fileNames.add(file.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                fileNames
        );

        listView.setAdapter(adapter);
    }
}