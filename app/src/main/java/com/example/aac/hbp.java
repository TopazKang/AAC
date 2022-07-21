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

public class hbp extends AppCompatActivity {

    TextView hbp_text;
    Button hbp_yes;
    Button hbp_no;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbp);

         hbp_text= (TextView) findViewById(R.id.hbp_text);
         hbp_yes= findViewById(R.id.hbp_yes);
         hbp_no= findViewById(R.id.hbp_no);

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
                tts.speak(hbp_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        hbp_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), hbp_level_test.class);
                startActivity(intent);
                //측정했으니깐 수치 확인 페이지로 전환
            }
        });

        hbp_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), hbp_didnt.class);
                startActivity(intent);
                //혈압을 측정하지 않아서 hbp_didnt로 전환
            }
        });
    }
}