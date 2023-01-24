package com.example.cucisepatutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Checkout2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_2);
    }

    public void launchVAPayment(View view){
        Intent intent = new Intent(this, VirtualAccountPaymentActivity.class);
        startActivity(intent);
    }
}