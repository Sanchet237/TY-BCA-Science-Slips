package com.example.registrationformwithvalidation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,email,password,age,mobile;
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

        register.setOnClickListener(v -> {

            if(name.getText().toString().isEmpty())
                showDialog("Enter Name");

            else if(email.getText().toString().isEmpty())
                showDialog("Enter Email");

            else if(password.getText().toString().isEmpty())
                showDialog("Enter Password");

            else if(age.getText().toString().isEmpty())
                showDialog("Enter Age");

            else if(mobile.getText().toString().isEmpty())
                showDialog("Enter Mobile Number");

            else
                showDialog("Registration Successful");
        });
    }

    void showDialog(String message)
    {
        DialogFragment dialog = MessageDialog.newInstance(message);
        dialog.show(getSupportFragmentManager(),"msg");
    }
}