package com.rodavid20.smscalldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDial = findViewById(R.id.btnDial);
        btnDial.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:12345678");
            intent.setData(uri);
            startActivity(intent);
        });
        Button btnCall = findViewById(R.id.btnMakeCall);
        btnCall.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri uri = Uri.parse("tel:12345678");
            intent.setData(uri);
            startActivity(intent);
        });
        Button btnSendSms = findViewById(R.id.btnSendSms);
        btnSendSms.setOnClickListener(v->{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("12334", null, "SMS Body", null, null);
        });
    }
}