package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etSurname, etClass, etMarks;
    private RadioGroup rgGender;
    private CheckBox cbReading, cbSports;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etName = findViewById(R.id.name);
        etSurname = findViewById(R.id.surname);
        etClass = findViewById(R.id.sclass);
        etMarks = findViewById(R.id.marks);
        rgGender = findViewById(R.id.genderGroup);
        cbReading = findViewById(R.id.h1);
        cbSports = findViewById(R.id.h2);
        btnSubmit = findViewById(R.id.submit);

        btnSubmit.setOnClickListener(v -> submitData());
    }

    private void submitData() {
        String name = etName.getText().toString().trim();
        String surname = etSurname.getText().toString().trim();
        String sClass = etClass.getText().toString().trim();
        String marks = etMarks.getText().toString().trim();

        // Validation
        if (name.isEmpty() || surname.isEmpty() || sClass.isEmpty() || marks.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rbGender = findViewById(selectedGenderId);
        String gender = rbGender.getText().toString();

        StringBuilder hobbies = new StringBuilder();
        if (cbReading.isChecked()) hobbies.append("Reading ");
        if (cbSports.isChecked()) hobbies.append("Sports ");
        
        String hobbiesStr = hobbies.length() > 0 ? hobbies.toString().trim() : "None";

        // Start SecondActivity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("class", sClass);
        intent.putExtra("marks", marks);
        intent.putExtra("gender", gender);
        intent.putExtra("hobbies", hobbiesStr);
        startActivity(intent);
    }
}