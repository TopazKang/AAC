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

public class sleep_time extends AppCompatActivity {

    TextView short_sleep;
    Button ok;
    Button not_ok;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uncomfortable_night);

        short_sleep = (TextView) findViewById(R.id.short_sleep);
        ok = findViewById(R.id.ok);
        not_ok = findViewById(R.id.not_ok);

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
                tts.speak(short_sleep.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //문제 없이 취침함
                finish();
            }
        });

        not_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sleep_problem.class);
                startActivity(intent);
                //잠자리 문제 파악으로 넘어감
            }
        });

    }
}