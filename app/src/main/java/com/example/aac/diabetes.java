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

public class diabetes extends AppCompatActivity {

    TextView diabetes_text;
    Button diabetes_yes;
    Button diabetes_no;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes);

         diabetes_text= (TextView) findViewById(R.id.diabetes_text);
         diabetes_yes= findViewById(R.id.diabetes_yes);
         diabetes_no= findViewById(R.id.diabetes_no);

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
                tts.speak(diabetes_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        diabetes_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), diabetes_level_test.class);
                startActivity(intent);
                //혈당 수치 측정 끝나서 문제 있는지로 넘어감
            }
        });

        diabetes_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), diabetes_didnt.class);
                startActivity(intent);
                //혈당 수치 측정을 하지 않아서 하는 방법으로 넘어감
            }
        });
    }
}