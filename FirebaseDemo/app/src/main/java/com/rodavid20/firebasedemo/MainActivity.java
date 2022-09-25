package com.rodavid20.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.rodavid20.firebasedemo.datamodel.Student;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(view -> {
            Student s = new Student(1, "abc", "cse");
            db.collection("students")
                    .add(s)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    });
        });
        Button btnRetrieve = findViewById(R.id.btnRetrieve);
        btnRetrieve.setOnClickListener(view -> {
            Spinner spNames = findViewById(R.id.spNames);
            ArrayList<String> names = new ArrayList<>();
            db.collection("students")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Student s = document.toObject(Student.class);
                                names.add(s.getName());
                            }
                            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
                            spNames.setAdapter(adapter);
                        }
                        else {
                            Toast.makeText(MainActivity.this,
                                    "error" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    });

        });

    }
}