package com.example.smswithattachmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phone, message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phone);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);

        send.setOnClickListener(v -> {

            Uri imageUri = Uri.parse("android.resource://"
                    + getPackageName() + "/" + R.drawable.sample);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");

            intent.putExtra("address", phone.getText().toString());
            intent.putExtra("sms_body", message.getText().toString());
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);

            startActivity(Intent.createChooser(intent,"Send MMS"));

        });
    }
}