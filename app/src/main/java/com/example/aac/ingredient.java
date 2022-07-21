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

public class ingredient extends AppCompatActivity {

    TextView ingredient_text;
    Button ingredient_full;
    Button ingredient_lack;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

         ingredient_text= (TextView) findViewById(R.id.ingredient_text);
         ingredient_full= findViewById(R.id.ingredient_full);
         ingredient_lack= findViewById(R.id.ingredient_lack);

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
                tts.speak(ingredient_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        ingredient_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //곳간이 차있으니깐 환경점수 up?
                finish();
            }
        });

        ingredient_lack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //재료가 없으므로 사야한다고 관리자 웹으로 알림
                finish();
            }
        });
    }
}