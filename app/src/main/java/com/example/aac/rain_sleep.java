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

public class rain_sleep extends AppCompatActivity {

    TextView rainy_sleep;
    Button dont_have;
    Button have;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_sleep);

        rainy_sleep = (TextView) findViewById(R.id.rainy_sleep);
        dont_have = findViewById(R.id.dont_have);
        have = findViewById(R.id.have);

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
                tts.speak(rainy_sleep.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        dont_have.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //잘 잤으니 상태 up?
                finish();
            }
        });

        have.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sleep_problem.class);
                startActivity(intent);
                //자는데 문제가 있으니 잠자리 문제파악으로 전환
            }
        });

    }
}