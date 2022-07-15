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

public class goodmorning extends AppCompatActivity {

    TextView morning;
    Button yes;
    Button no;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodmorning);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        morning = (TextView)findViewById(R.id.morning);

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
                tts.speak(morning.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        }, 100); // 0.1초후

        yes.setOnClickListener(new View.OnClickListener() { //yes를 클릭하면 감정상태 기록후 메인화면으로 넘어감.
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //잘 잤으니깐 상태점수 up?
                finish();
            }
        });

        no.setOnClickListener(new View.OnClickListener() { //no를 클릭하면 몸 상태 AAC로 넘어감.
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),sleep_problem.class);
                startActivity(intent);
            }
        });

    }
}