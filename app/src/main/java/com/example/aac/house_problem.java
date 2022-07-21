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

public class house_problem extends AppCompatActivity {

    TextView house_problem_text;
    Button house_clean;
    Button house_fix;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_problem);

         house_problem_text= (TextView) findViewById(R.id.house_problem_text);
         house_clean= findViewById(R.id.house_clean);
         house_fix= findViewById(R.id.house_fix);

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
                tts.speak(house_problem_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        house_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //혼자 해결이 불가한 청소 문제이므로 관리자한테 알림보낼것
                finish();
            }
        });

        house_fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //혼자 해결이 불가한 수리 문제이므로 관리자에게 알림 전송
                finish();
            }
        });
    }
}
