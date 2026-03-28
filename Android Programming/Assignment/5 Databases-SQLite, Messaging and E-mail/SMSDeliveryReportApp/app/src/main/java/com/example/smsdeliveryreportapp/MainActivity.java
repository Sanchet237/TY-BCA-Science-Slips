package com.example.smsdeliveryreportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    EditText phone, message;
    Button send;

    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phone);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS}, 1);

        send.setOnClickListener(v -> {

            PendingIntent sentPI = PendingIntent.getBroadcast(
                    this, 0, new Intent(SENT), PendingIntent.FLAG_IMMUTABLE);

            PendingIntent deliveredPI = PendingIntent.getBroadcast(
                    this, 0, new Intent(DELIVERED), PendingIntent.FLAG_IMMUTABLE);

            SmsManager sms = SmsManager.getDefault();

            sms.sendTextMessage(
                    phone.getText().toString(),
                    null,
                    message.getText().toString(),
                    sentPI,
                    deliveredPI
            );
        });

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Toast.makeText(context,
                        "SMS Sent Successfully",
                        Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(SENT));

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Toast.makeText(context,
                        "SMS Delivered",
                        Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(DELIVERED));

    }
}