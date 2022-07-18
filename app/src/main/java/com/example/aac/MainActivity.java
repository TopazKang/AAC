package com.example.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button goodmorning;
    Button comfortable_night;
    Button uncomfortable_night;
    Button sleep_time;
    Button rain_sleep;
    Button weather_1;
    Button stroll;
    Button read_book;
    Button call_to_other;
    Button have_plan;
    Button lunch;
    Button today_ending;
    Button seekbar_today;
    Button good_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goodmorning= findViewById(R.id.goodmorning); //잘 잤니? yes or no-->medical (아침1)
        comfortable_night= findViewById(R.id.comfortable_night); //편안한 밤이었니? (아침2)
        uncomfortable_night= findViewById(R.id.uncomfortable_night); //오늘 잠 설쳤니? --> 문제있으면 problem에서 어떤 문제인지 (아침3)
        sleep_time= findViewById(R.id.sleep_time); //오늘 취침시간이 다르네? 뭔 일있어? -->문제있으면 problem (아침 특수)
        rain_sleep= findViewById(R.id.weather_sleep); //비가 많이 오네, 잠은 잘 잤니? (아침4)
        weather_1= findViewById(R.id.weather_1); //오늘 날씨 더우니깐 추천하는거 해 (일과추천1)
        stroll= findViewById(R.id.stroll); //지금 하는거 없으면 산책할래? (일과추천 2)
        read_book= findViewById(R.id.read_book); //독서하면서 사색하는 시간은 어때? (일과추천3)
        call_to_other= findViewById(R.id.call_to_other); //지인에게 전화해볼래? (일과추천4)
        have_plan= findViewById(R.id.have_plan); //계획있는데 갈거야? plan_yes/no (일과질문1)
        lunch= findViewById(R.id.lunch); //점심 먹었어? (일과질문2)
        today_ending= findViewById(R.id.today_ending); //오늘 하루는 어땠어?(선택지 2개) (저녁질문1)
        //seekbar_today= findViewById(R.id.seekbar_today); //오늘 하루는 어땠어?(시크바) (저녁질문2)
        good_word= findViewById(R.id.good_word); //명언(따봉 효과) (저녁추천)
        //medical (완) (건강체크) 머리/팔/몸통/다리
        //sleep_problem (취침 문제파악) 주거지/몸
        //daylight_problem(활동 문제파악) 상담/몸
        //adoptable_problem (상황에 따라 자유롭게 문제파악)


        goodmorning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),goodmorning.class);
                startActivity(intent);
                finish();
            }
        });

        comfortable_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),comfortable_night.class);
                startActivity(intent);
                finish();
            }
        });

        uncomfortable_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), uncomfortable_night.class);
                startActivity(intent);
            }
        });

        sleep_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(), sleep_time.class);
                startActivity(intent);
            }
        });

        rain_sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), rain_sleep.class);
                startActivity(intent);
            }
        });

        weather_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), weather_1.class);
                startActivity(intent);
            }
        });

        stroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), stroll.class);
                startActivity(intent);
            }
        });

        read_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), read_book.class);
                startActivity(intent);
            }
        });

        call_to_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),call_to_other.class);
                startActivity(intent);
                finish();
            }
        });

        have_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), have_plan.class);
                startActivity(intent);
            }
        });

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lunch.class);
                startActivity(intent);
            }
        });

        today_ending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), today_ending.class);
                startActivity(intent);
            }
        });

        /*seekbar_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), seekbar_today.class);
                startActivity(intent);
            }
        });*/

        good_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), good_word.class);
                startActivity(intent);
            }
        });

    }
}