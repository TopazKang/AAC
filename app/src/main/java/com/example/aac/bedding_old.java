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

public class bedding_old extends AppCompatActivity {

    TextView bedding_old_text;
    Button bedding_old_wash;
    Button bedding_old_dry;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedding_old);

         bedding_old_text= (TextView) findViewById(R.id.bedding_old_text);
         bedding_old_wash= findViewById(R.id.bedding_old_wash);
         bedding_old_dry= findViewById(R.id.bedding_old_dry);

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
                tts.speak(bedding_old_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        bedding_old_wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), bedding_wash.class);
                startActivity(intent);
                //세탁을 선택했으므로 bedding_wash로 전환
            }
        });

        bedding_old_dry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), bedding_dry.class);
                startActivity(intent);
                //건조를 선택했으므로 bedding_dry로 전환
            }
        });
    }
}