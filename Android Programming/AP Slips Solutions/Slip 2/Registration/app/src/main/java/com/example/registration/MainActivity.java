package com.example.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    EditText name, email, password, age, mobile;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        age = findViewById(R.id.age);
        mobile = findViewById(R.id.mobile);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n = name.getText().toString();
                String e = email.getText().toString();
                String p = password.getText().toString();
                String a = age.getText().toString();
                String m = mobile.getText().toString();

                // Validation
                if (n.isEmpty() || e.isEmpty() || p.isEmpty() || a.isEmpty() || m.isEmpty()) {
                    showDialog("All fields are required");
                    return;
                }

                if (!e.contains("@")) {
                    showDialog("Invalid Email");
                    return;
                }

                if (p.length() < 6) {
                    showDialog("Password must be at least 6 characters");
                    return;
                }

                if (m.length() != 10) {
                    showDialog("Mobile number must be 10 digits");
                    return;
                }

                showDialog("Registration Successful!");
            }
        });
    }

    // Dialog Method
    void showDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message");
        builder.setMessage(msg);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}