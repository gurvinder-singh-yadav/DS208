package com.rodavid20.broadcastrecieverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver reciever;
    IntentFilter intentFilter;
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter
                = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        reciever = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG, "onReceive: Airplane mode");
                int value = Settings.Global.getInt(context.getContentResolver(),
                        Settings.Global.AIRPLANE_MODE_ON, 0);
                TextView tvResult = findViewById(R.id.tvResult);
                tvResult.setText(value == 0 ? "OFF" : "ON");
               }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(reciever, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(reciever);
    }
}