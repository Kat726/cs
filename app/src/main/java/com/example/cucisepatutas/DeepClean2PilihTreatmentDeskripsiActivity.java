package com.example.cucisepatutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class DeepClean2PilihTreatmentDeskripsiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_clean2_pilih_treatment_deskripsi);
    }

    public void launchCheckOutActivity1 (View view) {
        Intent intent = new Intent(this, Checkout1.class);
        startActivity(intent);
    }
}