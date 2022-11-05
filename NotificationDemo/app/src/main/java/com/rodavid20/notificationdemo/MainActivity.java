package com.rodavid20.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String channelId= "1";
    int notificationId = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotify = findViewById(R.id.btnNotify);
        btnNotify.setOnClickListener(v ->{
            createNotification();
        });
    }
    private void createNotification() {
        NotificationManagerCompat notificationManagerCompat
                = NotificationManagerCompat.from(this);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel =
                    new NotificationChannel(channelId, "NotificationDemo", importance);
            notificationManagerCompat.createNotificationChannel(channel);
        }
        Intent intent = new Intent(this,  ResultActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent
                = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("NotificationDemo")
                .setContentText("Sample Notification")
                        .setContentIntent(pendingIntent);

        notificationManagerCompat.notify(notificationId, builder.build());
        notificationId++; //comment this line if you want update the existing notification
    }
}