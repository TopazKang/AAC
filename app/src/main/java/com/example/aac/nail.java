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

public class nail extends AppCompatActivity {

    TextView nail_text;
    Button nail_l;
    Button nail_sh;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nail);

         nail_text= (TextView) findViewById(R.id.nail_text);
         nail_l= findViewById(R.id.nail_l);
         nail_sh= findViewById(R.id.nail_sh);

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
                tts.speak(nail_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        nail_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), nail_long.class);
                startActivity(intent);
                //손발톱이 기니깐 nail_long으로 전환
            }
        });

        nail_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //손발톱 관리가 잘 되었으므로 상태점수 up?
                finish();
            }
        });
    }
}