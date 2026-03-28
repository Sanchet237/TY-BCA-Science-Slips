package com.example.alarmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button setAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarm = findViewById(R.id.setAlarm);

        setAlarm.setOnClickListener(v -> {

            Toast.makeText(this,"Alarm Set!",Toast.LENGTH_SHORT).show();

            AlarmManager alarmManager =
                    (AlarmManager) getSystemService(ALARM_SERVICE);

            Intent intent = new Intent(MainActivity.this,
                    AlarmReceiver.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    MainActivity.this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
            );

            long triggerTime = System.currentTimeMillis() + 5000;

            alarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    triggerTime,
                    pendingIntent
            );

        });
    }
}