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

public class adoptable_problem extends AppCompatActivity {

    TextView adoptable_text;
    Button no_reason;
    Button hurt;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptable_problem);

        adoptable_text = (TextView) findViewById(R.id.adoptable_text);
        no_reason = findViewById(R.id.no_reason);
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
                tts.speak(adoptable_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        no_reason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //이유 없는 취소 상태점수 down
                finish();
            }
        });

        hurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), medical.class);
                startActivity(intent);
                //건강문제 파악
            }
        });
    }
}