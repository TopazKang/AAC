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

public class medical extends AppCompatActivity {

    TextView physical;
    Button head;
    Button body;
    Button leg;
    Button left_arm;
    Button right_arm;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        physical = (TextView) findViewById(R.id.physical);
        head= findViewById(R.id.head);
        body= findViewById(R.id.body);
        leg= findViewById(R.id.leg);
        left_arm= findViewById(R.id.left_arm);
        right_arm= findViewById(R.id.right_arm);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){    //알림 tts 부분
            @Override
            public void onInit(int status){
                if(status != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable()  {
            public void run(){
                tts.speak(physical.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100);

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //머리가 아프다는걸 웹사이트로 전송
                finish();
            }
        });

        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //가슴과 복부쪽이 아프다는걸 전송
                finish();
            }
        });
        right_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //팔이 아프다는걸 전송
                finish();
            }
        });
        left_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //팔이 아프다는걸 전송
                finish();
            }
        });
        leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //하반신이 아프다는걸 전송
                finish();
            }
        });
    }
}