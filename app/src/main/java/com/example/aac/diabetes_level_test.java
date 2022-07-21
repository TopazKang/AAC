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

public class diabetes_level_test extends AppCompatActivity {

    TextView diabetes_level_text;
    Button diabetes_level_yes;
    Button diabetes_level_no;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_level_test);

         diabetes_level_text= (TextView) findViewById(R.id.diabetes_level_text);
         diabetes_level_yes= findViewById(R.id.diabetes_level_yes);
         diabetes_level_no= findViewById(R.id.diabetes_level_no);

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
                tts.speak(diabetes_level_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        diabetes_level_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //혈당이 정상이니깐 건강/상태 점수 up?
                finish();
            }
        });

        diabetes_level_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), diabetes_bad.class);
                startActivity(intent);
                //혈당에 문제가 있어서 diabetes_bad로 전환
            }
        });
    }
}