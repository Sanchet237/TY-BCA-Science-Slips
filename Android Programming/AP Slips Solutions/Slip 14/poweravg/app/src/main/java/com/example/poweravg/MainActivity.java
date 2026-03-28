package com.example.poweravg;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        t1 = findViewById(R.id.t1);

        // Register for context menu
        registerForContextMenu(t1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return true;
        }

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);

        String result = "";

        if (item.getItemId() == R.id.menu_power) {
            double power = Math.pow(a, b);
            result = "Power = " + power;
        }

        else if (item.getItemId() == R.id.menu_avg) {
            double avg = (a + b) / 2.0;
            result = "Average = " + avg;
        }

        // Send result to second activity
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("result", result);
        startActivity(i);

        return true;
    }
}