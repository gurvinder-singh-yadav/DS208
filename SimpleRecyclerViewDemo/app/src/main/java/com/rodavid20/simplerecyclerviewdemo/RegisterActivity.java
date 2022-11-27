package com.rodavid20.simplerecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rodavid20.simplerecyclerviewdemo.datamodel.UserModel;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> {
            EditText etName = findViewById(R.id.etName);
            String name = etName.getText().toString().trim();
            EditText etPhone = findViewById(R.id.etPhone);
            String phone = etPhone.getText().toString();
            EditText etEmail = findViewById(R.id.etEmail);
            String email = etEmail.getText().toString();
            EditText etPassword = findViewById(R.id.etPassword);
            String password = etPassword.getText().toString();
            if (validateUserInput(name, phone, email, password)) {
                registerUser(name, phone, email, password);
            }
        });
    }

    private void registerUser(String name, String phone, String email, String password) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(result -> {
                    UserModel user = new UserModel(name, phone, email, firebaseAuth.getCurrentUser().getUid());
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("users")
                            .document(user.getUuid())
                            .set(user)
                            .addOnSuccessListener(ref -> {
                                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            })
                            .addOnFailureListener(error -> {
                                Toast.makeText(this, "Error " + error.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                })
                .addOnFailureListener(error -> {
                    Toast.makeText(this, "Error " + error.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private boolean validateUserInput(String name, String phone, String email, String password) {
        boolean success = false;
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Phone cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            success = true;
        }
        return success;
    }
}