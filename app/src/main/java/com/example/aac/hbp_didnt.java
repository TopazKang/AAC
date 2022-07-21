package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class hbp_didnt extends AppCompatActivity {

    Button hbp_test;
    TextView hbp_test_content;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbp_didnt);

        hbp_test= findViewById(R.id.hbp_test);
        hbp_test_content= findViewById(R.id.hbp_test_content);


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
                tts.speak(hbp_test_content.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        hbp_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //혈압을 안재서 잰거임 점수는..?
                finish();
            }
        });
    }
}
