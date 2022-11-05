package com.example.android.callsmsdemo;

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
        Button btnDial  = findViewById(R.id.dial);
        btnDial.setOnClickListener( v->{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:8858795");
            intent.setData(uri);
            startActivity(intent);
        });
        Button btnCall = findViewById(R.id.call);
        btnCall.setOnClickListener( v->{
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri uri = Uri.parse("tel:8858795");
            intent.setData(uri);
            startActivity(intent);
        });
        Button btnSend = findViewById(R.id.sms);
        btnSend.setOnClickListener( v->{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("8858795",null,"sms body",null,null);
        });
    }
}