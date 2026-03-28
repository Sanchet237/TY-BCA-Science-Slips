package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    String current = "";
    double num1 = 0, num2 = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
    }

    public void onButtonClick(View view) {
        Button btn = (Button) view;
        String text = btn.getText().toString();

        switch (text) {

            case "AC":
                current = "";
                num1 = num2 = 0;
                operator = "";
                tvResult.setText("0");
                break;

            case "+": case "-": case "*": case "/": case "%":
                num1 = Double.parseDouble(current);
                operator = text;
                current = "";
                break;

            case "=":
                num2 = Double.parseDouble(current);
                double result = 0;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num2 != 0 ? num1 / num2 : 0; break;
                    case "%": result = num1 % num2; break;
                }

                tvResult.setText(String.valueOf(result));
                current = String.valueOf(result);
                break;

            case "+/-":
                if (!current.isEmpty()) {
                    double val = Double.parseDouble(current);
                    val = -val;
                    current = String.valueOf(val);
                    tvResult.setText(current);
                }
                break;

            default:
                current += text;
                tvResult.setText(current);
        }
    }
}