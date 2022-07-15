package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class lunch_problem extends AppCompatActivity {

    TextView lunch_reason;
    Button dont_eat;
    Button cant_eat;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_problem);

        lunch_reason = (TextView) findViewById(R.id.lunch_reason);
        dont_eat = findViewById(R.id.dont_eat);
        cant_eat = findViewById(R.id.cant_eat);

        tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tts.speak(lunch_reason.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        dont_eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //점심을 이유없이 안먹었으므로 상태 down?
                finish();
            }
        });

        cant_eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), daylight_problem.class);
                startActivity(intent);
                //점심을 못먹는 사유 파악 필요
            }
        });
    }
}