package com.example.cucisepatutas.bottombar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cucisepatutas.R;

public class PesananBatalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_batal);
    }

    public void launchPesananSelesaiActivity(View view){
        Intent intent = new Intent(this, PesananActivity.PesananSelesaiActivity.class);
        startActivity(intent);
    }

    public void launchPesananBatalActivity(View view){
        Intent intent = new Intent(this, PesananBatalActivity.class);
        startActivity(intent);
    }
    public void launchHomeMenuActivitity(View view){
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }
    public void launchPesananActivity (View view){
        Intent intent = new Intent(this, PesananActivity.class);
        startActivity(intent);
    }
    public void launchaAkunActivity (View view){
        Intent intent = new Intent(this, AkunActivity.class);
        startActivity(intent);
    }

}