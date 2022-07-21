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

public class house extends AppCompatActivity {

    TextView house_text;
    Button house_yes;
    Button house_no;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

         house_text= (TextView) findViewById(R.id.house_text);
         house_yes= findViewById(R.id.house_yes);
         house_no= findViewById(R.id.house_no);

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
                tts.speak(house_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        house_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), house_problem.class);
                startActivity(intent);
                //집에 문제가 어떤 문제인지 확인하기 위해 house_problem으로 전환
            }
        });

        house_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //집에 문제가 없으므로 환경점수up?
                finish();
            }
        });
    }
}