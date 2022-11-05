package com.example.android.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String channelId = "1";
    int notifcationId = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotify = findViewById(R.id.btnNotify);
        btnNotify.setOnClickListener(v ->{
            createNotification();
        });
    }

    private  void createNotification(){
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            int immportance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId,"NotificationDemo",immportance);
            notificationManagerCompat.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("NotifcationDemo")
                .setContentText("Sample Notifcation");
        notificationManagerCompat.notify(notifcationId,builder.build());
        notifcationId++;
    }
}