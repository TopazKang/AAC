package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class nail_long extends AppCompatActivity {

    Button nail_button;
    TextView nail_content;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nail_long);

        nail_button= findViewById(R.id.nail_button);
        nail_content= findViewById(R.id.nail_content);


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
                tts.speak(nail_content.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        nail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //손발톱 정돈 했으니 청결/상태 점수 up?
                finish();
            }
        });
    }
}