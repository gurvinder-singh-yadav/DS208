package com.example.android.unittestingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = findViewById(R.id.et);
        Button btn = findViewById(R.id.btn);
        TextView tv = findViewById(R.id.tv);
        btn.setOnClickListener(view -> {
            tv.setText(et.getText().toString().toUpperCase());
        });
    }
}