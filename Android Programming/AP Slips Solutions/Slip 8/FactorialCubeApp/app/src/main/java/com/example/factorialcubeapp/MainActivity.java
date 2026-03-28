package com.example.factorialcubeapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        t1 = findViewById(R.id.t1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String s = e1.getText().toString();

        if (s.isEmpty()) {
            t1.setText("Enter number");
            return true;
        }

        int n = Integer.parseInt(s);

        if (item.getItemId() == R.id.menu_factorial) {
            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            t1.setText("Factorial = " + fact);
        }

        else if (item.getItemId() == R.id.menu_cube) {
            int cube = n * n * n;
            t1.setText("Cube = " + cube);
        }

        return true;
    }
}