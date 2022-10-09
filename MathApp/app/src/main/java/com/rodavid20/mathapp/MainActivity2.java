package com.rodavid20.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        if(intent != null) {
            int result = intent.getIntExtra("result", 0);

            TextView tvResult = findViewById(R.id.tvResult);
            tvResult.setText(String.valueOf(result));
        }
    }
}