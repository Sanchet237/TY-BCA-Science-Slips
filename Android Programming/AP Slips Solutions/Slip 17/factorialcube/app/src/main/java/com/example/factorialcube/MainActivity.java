package com.example.factorialcube;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        tvResult = findViewById(R.id.tvResult);

        // 🔥 THIS LINE IS MUST
        registerForContextMenu(etNumber);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Operation");
        menu.add(0, 1, 0, "Factorial");
        menu.add(0, 2, 0, "Cube");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String input = etNumber.getText().toString();

        if (input.isEmpty()) {
            tvResult.setText("Enter number first");
            return true;
        }

        int num = Integer.parseInt(input);

        if (item.getItemId() == 1) {
            int fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            tvResult.setText("Factorial: " + fact);
        }
        else if (item.getItemId() == 2) {
            int cube = num * num * num;
            tvResult.setText("Cube: " + cube);
        }

        return true;
    }
}