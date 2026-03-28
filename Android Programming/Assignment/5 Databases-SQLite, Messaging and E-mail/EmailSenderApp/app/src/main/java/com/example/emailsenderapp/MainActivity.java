package com.example.emailsenderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email,subject,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        subject=findViewById(R.id.subject);
        message=findViewById(R.id.message);
        send=findViewById(R.id.send);

        send.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("message/rfc822");

            intent.putExtra(Intent.EXTRA_EMAIL,
                    new String[]{email.getText().toString()});

            intent.putExtra(Intent.EXTRA_SUBJECT,
                    subject.getText().toString());

            intent.putExtra(Intent.EXTRA_TEXT,
                    message.getText().toString());

            startActivity(Intent.createChooser(intent,"Send Email"));

        });
    }
}