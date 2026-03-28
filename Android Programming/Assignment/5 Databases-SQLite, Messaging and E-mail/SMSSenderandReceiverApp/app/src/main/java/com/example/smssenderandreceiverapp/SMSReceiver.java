package com.example.smssenderandreceiverapp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        if(bundle != null)
        {
            Object[] pdus = (Object[]) bundle.get("pdus");

            for(Object pdu : pdus)
            {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);

                String msg = sms.getMessageBody();

                Toast.makeText(context,
                        "Received: "+msg,
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}