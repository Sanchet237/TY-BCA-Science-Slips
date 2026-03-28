package com.example.fileexplorer;

import android.os.Bundle;
import android.os.Environment;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> fileList;
    File currentDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        currentDir = Environment.getExternalStorageDirectory();

        showFiles(currentDir);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            File selected = new File(currentDir, fileList.get(position));

            if (selected.isDirectory()) {
                currentDir = selected;
                showFiles(currentDir);
            } else {
                Toast.makeText(this, "File: " + selected.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    void showFiles(File dir) {
        File[] files = dir.listFiles();

        fileList = new ArrayList<>();

        if (files != null) {
            for (File f : files) {
                fileList.add(f.getName());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                fileList
        );

        listView.setAdapter(adapter);
    }
}