package com.rodavid20.filedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.rodavid20.filedemo.helpers.CollegeDbAdapter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etUsername;
    SharedPreferences sp;
    CollegeDbAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        btnLogin.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("theme", etUsername.getText().toString());
            editor.commit();
            /*try {
                OutputStreamWriter streamWriter =
                        new OutputStreamWriter(
                                openFileOutput("demo.txt", Context.MODE_PRIVATE));
                streamWriter.write("abcd");
                streamWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        });

        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        });

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(view -> {
            adapter.insertStudent(etUsername.getText().toString());
        });

        Button btnRetrieve = findViewById(R.id.btnRetrieve);
        btnRetrieve.setOnClickListener(view -> {
            //etUsername.setText(adapter.getStudentNames());
        });
        adapter = new CollegeDbAdapter(this);
        adapter.open();
        Spinner spNames = findViewById(R.id.spNames);
        String[] studentNames = adapter.getStudentNames();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                studentNames);
        spNames.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        etUsername.setText(sp.getString("theme", ""));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.close();
    }
}