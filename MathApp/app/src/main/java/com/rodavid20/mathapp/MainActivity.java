package com.rodavid20.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] operations = {"Add", "Divide"};
        Spinner spOperations = findViewById(R.id.spOperations);
        ArrayAdapter adapter = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                operations);
        spOperations.setAdapter(adapter);

        /*ListView lvOperations = findViewById(R.id.lvOperations);
        lvOperations.setAdapter(adapter);

        lvOperations.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "position" + i,
                                Toast.LENGTH_SHORT).show();
                    }
                });*/
        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(view -> {
            int number1 = 0;
            int number2 = 0;

            EditText etNumber1 = findViewById(R.id.etNumber1);
            EditText etNumber2 = findViewById(R.id.etNumber2);

            number1 = Integer.parseInt(etNumber1.getText().toString());
            number2 = Integer.parseInt(etNumber2.getText().toString());

            int operation = spOperations.getSelectedItemPosition();
            int result = 0;
            switch (operation) {
                case 0:
                    result = number1 + number2;
                    break;
                default:
                    break;
            }
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("result", result);
            startActivity(intent);
            Toast.makeText(this,
                    String.valueOf(result), Toast.LENGTH_SHORT).show();
        });

    }
}