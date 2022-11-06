package com.rodavid20.graphicsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int cx = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CustomView view = new CustomView(this);
        //setContentView(view);
        CustomCircle customCircle = new CustomCircle(this);
        LinearLayout llContainer = findViewById(R.id.llContainer);
        llContainer.addView(customCircle);

        Button btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(view -> {
            cx +=50;
            customCircle.invalidate();
        });
    }

    private class CustomCircle extends View {
        public CustomCircle(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawCircle(cx, 400, 100, paint);

        }
    }

    private class CustomView extends View {

        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawRect(100, 100, 300,300, paint);
            paint.setColor(Color.GREEN);
            canvas.drawCircle(400, 400, 100, paint);
            paint.setColor(Color.DKGRAY);
            paint.setTextSize(100);
            canvas.drawText("Hello", 500, 100, paint);
            canvas.rotate(-45);
            canvas.drawText("Hello Rotateded", 100, 1000, paint);
            canvas.drawRect(100, 100, 300,300, paint);
        }
    }
}