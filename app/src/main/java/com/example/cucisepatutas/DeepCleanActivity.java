package com.example.cucisepatutas;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

import android.os.Bundle;

import com.example.cucisepatutas.bottombar.Homeactivity;

public class DeepCleanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_clean);
    }

    public void launchHomeMenuActivitity(View view) {
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }

    public void launchDeepClean2PilihTreatmentDeskripsiActivity(View view) {
        Intent intent = new Intent(this, DeepClean2PilihTreatmentDeskripsiActivity.class);
        startActivity(intent);
    }

}