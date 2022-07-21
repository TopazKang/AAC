package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class diabetes_bad extends AppCompatActivity {

    Button diabetes;
    TextView diabetes_content;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_bad);

        diabetes= findViewById(R.id.diabetes);
        diabetes_content= findViewById(R.id.diabetes_content);


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable()  {
            public void run(){
                tts.speak(diabetes_content.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //혈당 나쁨 건강점수 down?
                finish();
            }
        });
    }
}