package com.example.smssenderandreceiverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    EditText phone,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=findViewById(R.id.phone);
        message=findViewById(R.id.message);
        send=findViewById(R.id.send);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS,
                        Manifest.permission.RECEIVE_SMS,
                        Manifest.permission.READ_SMS},1);

        send.setOnClickListener(v -> {

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(
                    phone.getText().toString(),
                    null,
                    message.getText().toString(),
                    null,
                    null
            );

            Toast.makeText(this,"SMS Sent",Toast.LENGTH_SHORT).show();

        });
    }
}