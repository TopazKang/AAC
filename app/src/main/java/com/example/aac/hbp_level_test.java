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

public class hbp_level_test extends AppCompatActivity {

    TextView hbp_level_text;
    Button hbp_level_yes;
    Button hbp_level_no;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbp_level_test);

        hbp_level_text = (TextView) findViewById(R.id.hbp_level_text);
        hbp_level_yes= findViewById(R.id.hbp_level_yes);
        hbp_level_no= findViewById(R.id.hbp_level_no);

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
                tts.speak(hbp_level_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        hbp_level_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //혈당이 정상이니깐 건강이나 상태점수 up?
                finish();
            }
        });

        hbp_level_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), hbp_bad.class);
                startActivity(intent);
                //혈압 수치가 안좋아서 hbp_bad로 전환
            }
        });
    }
}