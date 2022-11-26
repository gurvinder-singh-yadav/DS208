package com.rodavid20.unittestingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etName = findViewById(R.id.etName);
        TextView tvName = findViewById(R.id.tvName);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(view -> {
            tvName.setText(etName.getText().toString().toUpperCase());
        });
    }
}