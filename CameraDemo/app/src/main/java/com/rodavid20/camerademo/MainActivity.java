package com.rodavid20.camerademo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCapture = findViewById(R.id.btnCapture);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ActivityResultLauncher<Intent> activityResultLauncher
                = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Bundle extras = result.getData().getExtras();
                        Bitmap image = (Bitmap)extras.get("data");
                        ImageView ivImage = findViewById(R.id.ivImage);
                        ivImage.setImageBitmap(image);
                    }
                }
        );
        btnCapture.setOnClickListener(v -> {
            activityResultLauncher.launch(intent);
        });
    }
}