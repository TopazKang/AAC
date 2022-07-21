package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class bedding_wash extends AppCompatActivity {

    Button wash;
    TextView wash_content;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedding_wash);

        wash= findViewById(R.id.wash);
        wash_content= findViewById(R.id.wash_content);


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
                tts.speak(wash_content.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //세탁 했으니 환경점수 up?
                finish();
            }
        });
    }
}
