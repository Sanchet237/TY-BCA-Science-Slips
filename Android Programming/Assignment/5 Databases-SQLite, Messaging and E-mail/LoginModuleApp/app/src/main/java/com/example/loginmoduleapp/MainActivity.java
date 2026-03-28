package com.example.loginmoduleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        db = openOrCreateDatabase("LoginDB", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS Login(username TEXT,password TEXT)");

        // Insert default user only once
        Cursor c = db.rawQuery("SELECT * FROM Login", null);

        if (c.getCount() == 0) {
            db.execSQL("INSERT INTO Login VALUES('admin','1234')");
        }

        login.setOnClickListener(v -> {

            String u = username.getText().toString();
            String p = password.getText().toString();

            Cursor cursor = db.rawQuery(
                    "SELECT * FROM Login WHERE username=? AND password=?",
                    new String[]{u, p});

            if (cursor.moveToFirst()) {

                Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                i.putExtra("user", u);
                startActivity(i);

            } else {

                Toast.makeText(MainActivity.this,
                        "Login Failed",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}