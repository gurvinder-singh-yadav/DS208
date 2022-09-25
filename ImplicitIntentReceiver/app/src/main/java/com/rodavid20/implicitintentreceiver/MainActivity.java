package com.rodavid20.implicitintentreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String data = intent.getStringExtra(Intent.EXTRA_TEXT);
        TextView tvMessage = findViewById(R.id.tvMessage);
        tvMessage.setText(data);
    }
}