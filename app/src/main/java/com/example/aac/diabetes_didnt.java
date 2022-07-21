package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class diabetes_didnt extends AppCompatActivity {

    Button diabetes_test;
    TextView test_measure_content;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_didnt);

        diabetes_test= findViewById(R.id.diabetes_test);
        test_measure_content= findViewById(R.id.test_measure_content);


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
                tts.speak(test_measure_content.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        diabetes_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //그냥 혈당 검사했는데?
                finish();
            }
        });
    }
}