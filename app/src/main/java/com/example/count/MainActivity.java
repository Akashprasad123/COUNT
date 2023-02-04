package com.example.count;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    int a = 1;

    Button add,sub,reset;
    TextView count;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple));

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        reset = findViewById(R.id.reset);
        count = findViewById(R.id.count);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.click);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               i = i+a;
               count.setText(i+"");
                //play sound
                mediaPlayer.start();

            }
        });

        sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i > 0) {
                    i = i-a;
                    count.setText(i+"");
                    //play sound
                    mediaPlayer.start();
                } else {
                    info("positive numbers are used to count");
                    //taking vibrator service
                    vibrator.vibrate(100);

                }
            }
        });

        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                count.setText(i+"");
            }
        });
        }
    public void info(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
    }
}