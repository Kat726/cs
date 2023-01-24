package com.example.cucisepatutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Checkout1 extends AppCompatActivity {
    Button btn_pck_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout1);

        //btn_pck_address = (Button) findViewById(R.id.btn_pck_address);

        btn_pck_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PopUpAddressChoose.class);
                startActivity(i);
            }
        });
    }
}