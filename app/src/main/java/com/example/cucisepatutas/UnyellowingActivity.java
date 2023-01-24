package com.example.cucisepatutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cucisepatutas.bottombar.Homeactivity;

public class UnyellowingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unyellowing);
    }

    public void launchHomeMenuActivitity(View view) {
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }

}