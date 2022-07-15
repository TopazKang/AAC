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

public class today_ending extends AppCompatActivity {

    TextView ending_text;
    Button good_end;
    Button bad_end;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_ending);

        ending_text = (TextView) findViewById(R.id.ending_text);
        good_end = findViewById(R.id.good_end);
        bad_end = findViewById(R.id.bad_end);

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
                tts.speak(ending_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        good_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //하루를 잘 끝냈으므로 상태점수 up?
                finish();
            }
        });

        bad_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), daylight_problem.class);
                startActivity(intent);
                //문제 파악단으로 전환
            }
        });
    }
}