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

public class have_plan extends AppCompatActivity {

    TextView plan_text;
    Button yes_plan;
    Button no_plan;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_plan);

        plan_text = (TextView) findViewById(R.id.plan_text);
        yes_plan= findViewById(R.id.yes_plan);
        no_plan = findViewById(R.id.no_plan);

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
                tts.speak(plan_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        yes_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //계획 이행했으므로 상태점수 up
                finish();
            }
        });

        no_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adoptable_problem.class);
                startActivity(intent);
            }
        });
    }
}