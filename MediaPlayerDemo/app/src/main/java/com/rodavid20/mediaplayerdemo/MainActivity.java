package com.rodavid20.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExternal = findViewById(R.id.btnExternal);
        btnExternal.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
            intent.setDataAndType(uri, "audio/*");
            startActivity(intent);
        });

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(view -> {
            //create does both setDataSource and Prepare
            mediaPlayer = MediaPlayer.create(this, R.raw.sample);
            mediaPlayer.start();
        });

        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(view -> {
            if(mediaPlayer != null) {
                mediaPlayer.stop();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}