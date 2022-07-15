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

public class daylight_problem extends AppCompatActivity {

    TextView daylight_text;
    Button counseling;
    Button hurt;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daylight_problem);

        daylight_text = (TextView) findViewById(R.id.daylight_text);
        counseling = findViewById(R.id.counseling);
        hurt = findViewById(R.id.hurt);

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
                tts.speak(daylight_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        counseling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //상담 신청 정보 서버로 전송
                finish();
            }
        });

        hurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), medical.class);
                startActivity(intent);
            }
        });
    }
}