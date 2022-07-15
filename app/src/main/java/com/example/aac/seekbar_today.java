package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class seekbar_today extends AppCompatActivity {

    TextView seekbar_text;
    TextView seekbar_score;
    SeekBar seekBar;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_today);

        seekbar_text = (TextView)findViewById(R.id.seekbar_text);
        seekbar_score = (TextView)findViewById(R.id.seekbar_score);
        seekBar = findViewById(R.id.seekBar);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
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
                tts.speak(seekbar_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //시크바 조작중
                seekbar_score.setText(String.format("%d %", seekBar.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //시크바 처음 터치
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //시크바 터치 끝
            }
        });


    }
}