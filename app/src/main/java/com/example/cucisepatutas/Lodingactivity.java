package com.example.cucisepatutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Lodingactivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodingactivity);
    timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(Lodingactivity.this,Loanding2Activity.class);
            startActivity(intent);
            finish();

        }
    }, 4000);
    }
}